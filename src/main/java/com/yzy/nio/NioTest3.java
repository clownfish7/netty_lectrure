package com.yzy.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author yzy
 * @classname NioTest3
 * @description ByteBuffer read-write
 * @create 2019-07-01 13:51
 */
public class NioTest3 {

    public static void main(String[] args) throws IOException {
        FileOutputStream os = new FileOutputStream("NioTest3.txt");
        FileChannel channel = os.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        byte[] message = "hello world clownfish7".getBytes();
//        for (byte b : message) {
//            byteBuffer.put(b);
//        }
        byteBuffer.put(message);

        byteBuffer.flip();
        channel.write(byteBuffer);
        os.close();
    }
}
