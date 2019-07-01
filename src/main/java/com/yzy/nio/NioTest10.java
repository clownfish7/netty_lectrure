package com.yzy.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @author yzy
 * @classname NioTest10
 * @description fileLock
 * @create 2019-07-01 17:31
 */
public class NioTest10 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("NioTest10.txt", "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();

        //param:shared true:共享锁 false:排他锁
        FileLock fileLock = fileChannel.lock(3,6,true);

        System.out.println(fileLock.isValid());
        System.out.println(fileLock.isShared());

        fileLock.release();
        randomAccessFile.close();
    }
}
