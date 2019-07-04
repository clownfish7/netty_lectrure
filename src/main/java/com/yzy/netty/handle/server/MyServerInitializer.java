package com.yzy.netty.handle.server;

import com.yzy.netty.handle.codec.MyByte2LongDecoder;
import com.yzy.netty.handle.codec.MyLong2StringDecoder;
import com.yzy.netty.handle.codec.MyMessage2ByteEncode;
import com.yzy.netty.handle.codec.MyReplayingDecoder;
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

        pipeline.addLast(new MyMessage2ByteEncode());
        pipeline.addLast(new MyReplayingDecoder());
        pipeline.addLast(new MyLong2StringDecoder());
        pipeline.addLast(new MyServerHandle());
    }
}
