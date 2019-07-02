package com.yzy.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.*;

/**
 * @author yzy
 * @classname NioServer
 * @description TODO
 * @create 2019-07-02 10:34
 */
public class NioServer {

    private static Map<String, SocketChannel> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);

        ServerSocket socket = serverSocketChannel.socket();
        socket.bind(new InetSocketAddress(8899));

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            selector.select();

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            selectionKeys.forEach(selectionKey -> {

                final SocketChannel client;

                try {
                    if (selectionKey.isAcceptable()) {
                        ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();

                        client = channel.accept();
                        client.configureBlocking(false);
                        client.register(selector, SelectionKey.OP_READ);
                        map.put(UUID.randomUUID() + "", client);

                    } else if (selectionKey.isReadable()) {
                        client = (SocketChannel) selectionKey.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(512);
                        int len = client.read(buffer);
                        if (len > 0) {
                            buffer.flip();

                            Charset charset = Charset.forName("utf-8");
                            String receivedMessage = String.valueOf(charset.decode(buffer).array());
                            System.out.println(client + ":" + receivedMessage);
//                            client.write(buffer);

                            String senderKey = null;
                            for (Map.Entry<String, SocketChannel> stringSocketChannelEntry : map.entrySet()) {
                                if (stringSocketChannelEntry.getValue() == client) {
                                    senderKey = stringSocketChannelEntry.getKey();
                                    break;
                                }
                            }

                            for (Map.Entry<String, SocketChannel> stringSocketChannelEntry : map.entrySet()) {

                                ByteBuffer byteBuffer = ByteBuffer.allocate(512);
                                byteBuffer.put((senderKey + ":" + receivedMessage).getBytes());
                                byteBuffer.flip();
                                stringSocketChannelEntry.getValue().write(byteBuffer);
                            }

                        }

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            selectionKeys.clear();
        }
    }
}
