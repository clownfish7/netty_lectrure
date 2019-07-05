package com.yzy.netty.handle3;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;
import java.util.UUID;

/**
 * @author yzy
 * @classname MyServerHandle
 * @description TODO
 * @create 2019-07-05 10:03
 */
public class MyServerHandle extends SimpleChannelInboundHandler<PersonProtocol> {

    private int count;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, PersonProtocol msg) throws Exception {
        int length = msg.getLength();
        byte[] content = msg.getContent();

        System.out.println("服务器接收到的数据：");
        System.out.println("长度：" + length);
        System.out.println("内容：" + new String(content, Charset.forName("utf-8")));

        System.out.println("服务端接收消息数："+ ++count);

        String response = UUID.randomUUID().toString();
        int respLength = response.getBytes().length;
        byte[] respContent = response.getBytes("utf-8");
        PersonProtocol personProtocol = new PersonProtocol();
        personProtocol.setLength(respLength);
        personProtocol.setContent(respContent);

        ctx.writeAndFlush(personProtocol);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
