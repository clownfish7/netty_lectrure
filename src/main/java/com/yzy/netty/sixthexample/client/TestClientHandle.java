package com.yzy.netty.sixthexample.client;

import com.yzy.netty.sixthexample.MyDataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author You
 * @create 2019-06-22 23:58
 */
@SuppressWarnings("all")
public class TestClientHandle extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {

//    @Override
//    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.Student msg) throws Exception {
//        System.out.println(msg);
//        System.out.println(msg.getName());
//        System.out.println(msg.getAddress());
//        System.out.println(msg.getAge());
//    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {
        MyDataInfo.MyMessage.DataType dataType = msg.getDataType();
        switch (dataType.getNumber()) {
            case 1:
                System.out.println(msg.getStudent().getName());
                System.out.println(msg.getStudent().getAge());
                System.out.println(msg.getStudent().getAddress());
                break;
            case 2:
                System.out.println(msg.getDog().getName());
                System.out.println(msg.getDog().getAge());
                break;
            case 3:
                System.out.println(msg.getCat().getName());
                System.out.println(msg.getCat().getAge());
                System.out.println(msg.getCat().getCity());
                break;
        }
    }
}
