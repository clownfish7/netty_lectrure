package com.yzy.zerocopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.time.Year;

/**
 * @author yzy
 * @classname NewClient
 * @description TODO
 * @create 2019-07-02 16:58
 */
public class NewClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8899));
        socketChannel.configureBlocking(true);


        File file = new File("D:\\y2y\\01A.rar");
        FileChannel fileChannel = new FileInputStream(file).getChannel();

        long startTime = System.currentTimeMillis();

        long transferCount = fileChannel.transferTo(0, fileChannel.size(), socketChannel);

        System.out.println("发送总字节数："+transferCount+", 耗时："+(System.currentTimeMillis()-startTime));

        fileChannel.close();
        socketChannel.close();
    }
}
