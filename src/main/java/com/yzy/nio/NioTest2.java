package com.yzy.nio;

import io.netty.buffer.ByteBuf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author yzy
 * @classname NioTest2
 * @description TODO
 * @create 2019-07-01 13:44
 */
public class NioTest2 {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("NioTest2.txt");
        FileChannel fileChannel = in.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        fileChannel.read(byteBuffer);

        byteBuffer.flip();
        while (byteBuffer.remaining()>0) {
            byte b = byteBuffer.get();
            System.out.print((char)b);
        }
        in.close();
    }
}
