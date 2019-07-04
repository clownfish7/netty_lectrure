package com.yzy.netty.handle.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * @author yzy
 * @classname MyLong2StringDecoder
 * @description TODO
 * @create 2019-07-04 20:17
 */
public class MyLong2StringDecoder extends MessageToMessageDecoder<Long> {

    @Override
    protected void decode(ChannelHandlerContext ctx, Long msg, List<Object> out) throws Exception {
        System.out.println("MyLong2StringDecoder");
        out.add(msg + "");
    }
}
