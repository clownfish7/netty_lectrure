package com.yzy.netty.handle2.server;

import com.yzy.netty.handle2.codec.MyLong2StringDecoder;
import com.yzy.netty.handle2.codec.MyMessage2ByteEncode;
import com.yzy.netty.handle2.codec.MyReplayingDecoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author yzy
 * @classname MyServerInitializer
 * @description TODO
 * @create 2019-07-04 17:43
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast(new MyServerHandle());
    }
}
