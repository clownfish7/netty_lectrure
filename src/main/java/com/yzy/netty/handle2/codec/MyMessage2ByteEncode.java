package com.yzy.netty.handle2.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author yzy
 * @classname MyMessage2ByteEncode
 * @description TODO
 * @create 2019-07-04 18:47
 */
public class MyMessage2ByteEncode extends MessageToByteEncoder<Long> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Long msg, ByteBuf out) throws Exception {
        System.out.println("encode invoked !");

        System.out.println(msg);
        out.writeLong(msg);
    }
}
