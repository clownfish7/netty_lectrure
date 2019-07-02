package com.yzy.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yzy
 * @classname NioClient
 * @description TODO
 * @create 2019-07-02 11:47
 */
public class NioClient {
    public static void main(String[] args) throws IOException {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);

            Selector selector = Selector.open();
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
            socketChannel.connect(new InetSocketAddress("localhost", 8899));

            while (true) {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                selectionKeys.forEach(selectionKey -> {
                    if (selectionKey.isConnectable()) {
                        SocketChannel channel = (SocketChannel) selectionKey.channel();
                        if (channel.isConnectionPending()) {
                            try {
                                channel.finishConnect();
                                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                                byteBuffer.put("连接成功".getBytes());
                                byteBuffer.flip();
                                channel.write(byteBuffer);

                                ExecutorService executorService = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
                                executorService.submit(()->{
                                    while (true) {
                                        byteBuffer.clear();
                                        InputStreamReader reader = new InputStreamReader(System.in);
                                        BufferedReader br = new BufferedReader(reader);
                                        String message = br.readLine();
                                        byteBuffer.put(message.getBytes());
                                        byteBuffer.flip();
                                        channel.write(byteBuffer);
                                    }
                                });
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            channel.register(selector, SelectionKey.OP_READ);
                        } catch (ClosedChannelException e) {
                            e.printStackTrace();
                        }
                    } else if (selectionKey.isReadable()) {
                        SocketChannel channel = (SocketChannel) selectionKey.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        try {
                            int len = channel.read(byteBuffer);
                            if (len > 0) {
                                String message = new String(byteBuffer.array(),0,len);
                                System.out.println(message);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                selectionKeys.clear();
            }
        } catch (Exception e){

        }
    }
}
