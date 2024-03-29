package com.yzy.nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

/**
 * @author yzy
 * @classname NioTest1
 * @description IntBuffer
 * @create 2019-07-01 13:07
 */
public class NioTest1 {

    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(10);

        for (int i = 0; i < buffer.capacity(); i++) {
            int randomNum = new SecureRandom().nextInt(20);
            buffer.put(randomNum);
        }
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }
}
