package com.yzy.netty.handle3;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @author yzy
 * @classname MyPersonDecoder
 * @description TODO
 * @create 2019-07-05 9:58
 */
public class MyPersonDecoder extends ReplayingDecoder<Void> {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MyPersonDecoder decode invoked!");

        int length = in.readInt();

        byte[] cotent = new byte[length];
        in.readBytes(cotent);

        PersonProtocol personProtocol = new PersonProtocol();
        personProtocol.setLength(length);
        personProtocol.setContent(cotent);

        out.add(personProtocol);
    }
}
