package com.yzy.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

/**
 * @author yzy
 * @classname ByteBufTest0
 * @description TODO
 * @create 2019-07-04 11:55
 */
public class ByteBufTest1 {

    public static void main(String[] args) {
        ByteBuf buf = Unpooled.copiedBuffer("hello bytebuf", Charset.forName("utf-8"));

        if (buf.hasArray()) {
            byte[] array = buf.array();
            System.out.println(new String(array, Charset.forName("utf-8")));
            System.out.println(buf);

            System.out.println(buf.arrayOffset());
            System.out.println(buf.readerIndex());
            System.out.println(buf.writerIndex());
            System.out.println(buf.capacity());

            int length = buf.readableBytes();
            System.out.println(length);

            System.out.println(buf.getCharSequence(0, 5, Charset.forName("utf-8")));

        }
    }
}
