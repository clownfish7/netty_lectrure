package com.yzy.netty.handle2.client;

import com.yzy.netty.handle2.codec.MyMessage2ByteEncode;
import com.yzy.netty.handle2.codec.MyReplayingDecoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;


/**
 * @author You
 * @create 2019-06-22 23:12
 */
public class MyClientInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast(new MyClientHandle());
    }
}
