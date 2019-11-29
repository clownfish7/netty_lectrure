package com.yzy.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.Base64;

/**
 * @author yzy
 * @classname ByteBufTest0
 * @description TODO
 * @create 2019-07-04 11:55
 */
public class ByteBufTest0 {

    public static void main(String[] args) {
        ByteBuf byteBuf = Unpooled.buffer(10);

        for (int i = 0; i < 10; i++) {
            byteBuf.writeByte(i);
        }

        for (int i = 0; i < byteBuf.capacity(); i++) {
            System.out.println(byteBuf.getByte(i));
        }

        ByteBuf bf = Unpooled.buffer(23);
        bf.writeByte(1);
        bf.writeByte(9);
        bf.writeBytes("47.97.8.7".getBytes(Charset.forName("gbk")));
        bf.writeByte(0);
        bf.writeByte(0);
//        bf.writeByte(Byte.parseByte("1f", 16));
//        bf.writeByte(Byte.parseByte("98", 16));
        bf.writeByte(31);
        bf.writeByte(-104);
        bf.writeByte(0);
        bf.writeByte(0);
        bf.writeByte(0);
        bf.writeByte(0);
        bf.writeByte(0);
        bf.writeByte(0);
        bf.writeByte(0);
        bf.writeByte(0);

        byte[] bb = new byte[23];
        bf.readBytes(bb);
        System.out.println(new String(Base64.getEncoder().encode(bb)));

        System.out.println("drivers".getBytes(Charset.forName("gbk")).length);
        bf = Unpooled.buffer(232);
        bf.writeByte(0);
        bf.writeByte(9);
        bf.writeBytes("47.97.8.7".getBytes(Charset.forName("gbk")));
        bf.writeByte(0);
        bf.writeByte(0);
        bf.writeByte(31);
        bf.writeByte(-104);
        bf.writeByte(6);
        bf.writeBytes("driver".getBytes(Charset.forName("gbk")));


        bb = new byte[22];
        bf.readBytes(bb);
        System.out.println(new String(Base64.getEncoder().encode(bb)));

        try {
            System.out.println(URLDecoder.decode("http%3A%2F%2F47.97.8.7%3A8080%2Fponysafety2%2Fdriver_face%2FFACEIDSJ001%2F330998201910290001.jpg", "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
