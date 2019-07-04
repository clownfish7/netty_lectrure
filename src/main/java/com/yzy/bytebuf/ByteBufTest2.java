package com.yzy.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * @author yzy
 * @classname ByteBufTest0
 * @description TODO
 * @create 2019-07-04 11:55
 */
public class ByteBufTest2 {

    public static void main(String[] args) {

        CompositeByteBuf bufs = Unpooled.compositeBuffer();

        ByteBuf heapBuf = Unpooled.buffer(10);
        ByteBuf directBuf = Unpooled.directBuffer(8);

        bufs.addComponents(heapBuf,directBuf);
//        bufs.removeComponent(0);

        bufs.forEach(a ->{
            System.out.println(a);
        });
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.rewind();
        buffer.compact();

    }
}
