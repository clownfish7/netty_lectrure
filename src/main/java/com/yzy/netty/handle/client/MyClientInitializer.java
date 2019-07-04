package com.yzy.netty.handle.client;

import com.yzy.netty.handle.codec.MyByte2LongDecoder;
import com.yzy.netty.handle.codec.MyMessage2ByteEncode;
import com.yzy.netty.handle.codec.MyReplayingDecoder;
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

        pipeline.addLast(new MyMessage2ByteEncode());
        pipeline.addLast(new MyReplayingDecoder());
        pipeline.addLast(new MyClientHandle());
    }
}
