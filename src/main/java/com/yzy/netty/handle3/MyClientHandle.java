package com.yzy.netty.handle3;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

/**
 * @author yzy
 * @classname MyClientHandle
 * @description TODO
 * @create 2019-07-05 10:09
 */
public class MyClientHandle extends SimpleChannelInboundHandler<PersonProtocol> {

    private int count;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 10; i++) {
            PersonProtocol p = new PersonProtocol();
            String s = "from client ;";
            p.setLength(s.getBytes("utf-8").length);
            p.setContent(s.getBytes("utf-8"));
            ctx.writeAndFlush(p);
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, PersonProtocol msg) throws Exception {
        System.out.println("客户端接收的消息: ");
        System.out.println("长度: "+msg.getLength());
        System.out.println("内容: "+new String(msg.getContent(),Charset.forName("utf-8")));
        System.out.println("客户端接收的消息数量: "+ ++count);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
