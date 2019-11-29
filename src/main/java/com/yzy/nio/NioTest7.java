package com.yzy.nio;

import io.netty.buffer.ByteBuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * @author yzy
 * @classname NioTest7
 * @description ByteBufferReadOnly
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

        ByteBuffer byteBuf = ByteBuffer.allocate(23);
        byteBuf.put((byte) 0x01);
        byteBuf.put((byte) 9);
        byteBuf.put("47.97.8.7".getBytes(Charset.forName("GBK")));
        byteBuf.put(int2DWORD(8088));
        byteBuf.put(int2DWORD(0));
        byteBuf.put(int2DWORD(0));

        byteBuf.flip();
        byte[] array = byteBuf.array();
        System.out.println(new String(array,Charset.forName("GBK")));


    }

    /**
     * int转dword（4字节）
     * @param value
     * @return
     */
    public static byte[] int2DWORD(long value) {
        byte byte0 = (byte) ((value >> 24) & 0xff);
        byte byte1 = (byte) ((value >> 16) & 0xff);
        byte byte2 = (byte) ((value >> 8) & 0xff);
        byte byte3 = (byte) (value & 0xff);

        return new byte[] {byte0, byte1, byte2, byte3};

    }
}
