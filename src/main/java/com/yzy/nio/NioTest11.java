package com.yzy.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @author yzy
 * @classname NioTest11
 * @description Scrattering & Gathering
 * @create 2019-07-01 17:40
 */
public class NioTest11 {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress("localhost",8899);
        serverSocketChannel.socket().bind(address);

        int message = 2 + 3 + 4;
        ByteBuffer[] byteBuffers = new ByteBuffer[3];
        byteBuffers[0] = ByteBuffer.allocate(2);
        byteBuffers[1] = ByteBuffer.allocate(3);
        byteBuffers[2] = ByteBuffer.allocate(4);

        SocketChannel socketChannel = serverSocketChannel.accept();

        while (true) {
            int bytesRead = 0;
            while (bytesRead < message) {
                long r = socketChannel.read(byteBuffers);
                bytesRead += r;
                System.out.println("bytesRead: " + bytesRead);

                Arrays.asList(byteBuffers).stream().map(
                        buffer -> "position: " + buffer.position() + ",limit: " + buffer.limit()
                ).forEach(System.out::println);
            }

            Arrays.asList(byteBuffers).forEach(buffer -> {
                buffer.flip();
            });

            long byteWritten = 0;
            while (byteWritten < message) {
                long r = socketChannel.write(byteBuffers);
                byteWritten += r;
            }

            Arrays.asList(byteBuffers).forEach(buffer ->{
                buffer.clear();
            });
        }
    }
}
