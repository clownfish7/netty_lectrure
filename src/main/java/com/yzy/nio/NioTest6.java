package com.yzy.nio;

import java.nio.ByteBuffer;

/**
 * @author yzy
 * @classname NioTest6
 * @description TODO
 * @create 2019-07-01 15:40
 */
public class NioTest6 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        for (int i = 0; i < 10; i++) {
            byteBuffer.put((byte) i);
        }

        byteBuffer.position(2);
        byteBuffer.limit(6);
        ByteBuffer slice = byteBuffer.slice();
        for (int i = 0; i < slice.capacity(); i++) {
            byte b = slice.get();
            b *= 2;
            slice.put(i, b);
        }

        byteBuffer.position(0);
        byteBuffer.limit(byteBuffer.capacity());
        while (byteBuffer.hasRemaining()) {
            System.out.println(byteBuffer.get());
        }
    }
}
