package com.yzy.nio;

import java.nio.ByteBuffer;

/**
 * @author yzy
 * @classname NioTest5
 * @description bytebuffer put get with same module
 * @create 2019-07-01 15:35
 */
public class NioTest5 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(64);

        buffer.putInt(15);
        buffer.putLong(8888888L);
        buffer.putDouble(3.1415926);
        buffer.putChar('y');
        buffer.putShort((short) 10);

        buffer.flip();

        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getDouble());
        System.out.println(buffer.getChar());
        System.out.println(buffer.getShort());
    }
}
