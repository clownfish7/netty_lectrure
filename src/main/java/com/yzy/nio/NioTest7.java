package com.yzy.nio;

import java.nio.ByteBuffer;

/**
 * @author yzy
 * @classname NioTest7
 * @description TODO
 * @create 2019-07-01 15:56
 */
public class NioTest7 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

        System.out.println(byteBuffer.getClass());

        for (int i = 0; i < 10; i++) {
            byteBuffer.put((byte) i);
        }
        ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        System.out.println(readOnlyBuffer.getClass());
    }
}
