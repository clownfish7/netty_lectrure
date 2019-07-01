package com.yzy.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author yzy
 * @classname NioTest9
 * @description heap outside memory
 * @create 2019-07-01 17:21
 */
public class NioTest9 {

    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("NioTest9.txt", "rw");
        FileChannel fileChannel = file.getChannel();

        MappedByteBuffer mapByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        mapByteBuffer.put(0,(byte)'a');
        mapByteBuffer.put(3,(byte)'b');

        file.close();
    }
}
