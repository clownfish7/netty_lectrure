package com.yzy.netty.handle3;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author yzy
 * @classname MyClientInitializer
 * @description TODO
 * @create 2019-07-05 10:15
 */
public class MyClientInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new MyPersonDecoder());
        pipeline.addLast(new MyPersonEncoder());

        pipeline.addLast(new MyClientHandle());
    }
}
