package com.yzy.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author yzy
 * @classname NioTest4
 * @description TODO
 * @create 2019-07-01 14:59
 */
public class NioTest4 {
    public static void main(String[] args) throws IOException {
        FileInputStream is = new FileInputStream("NioTest4_in.txt");
        FileOutputStream os = new FileOutputStream("NioTest4_out.txt");

        FileChannel isChannel = is.getChannel();
        FileChannel osChannel = os.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        while (isChannel.read(byteBuffer) != -1) {

            byteBuffer.flip();
            osChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        is.close();
        os.close();
    }
}
