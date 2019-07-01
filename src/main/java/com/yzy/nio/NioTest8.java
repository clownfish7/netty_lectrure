package com.yzy.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author yzy
 * @classname NioTest8
 * @description Direct zero copy
 * @create 2019-07-01 16:33
 */
public class NioTest8 {
    public static void main(String[] args) throws IOException {
        FileInputStream is = new FileInputStream("NioTest8_in.txt");
        FileOutputStream os = new FileOutputStream("NioTest8_out.txt");

        FileChannel isChannel = is.getChannel();
        FileChannel osChannel = os.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(512);

        while (isChannel.read(byteBuffer) != -1) {

            byteBuffer.flip();
            osChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        is.close();
        os.close();
    }
}
