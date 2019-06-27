package com.yzy.netty.sixthexample.server;

import com.yzy.netty.sixthexample.MyDataInfo;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

/**
 * @author yzy
 * @classname TestServerHandle
 * @description TODO
 * @create 2019-06-27 11:44
 */
@SuppressWarnings("all")
public class TestServerHandle extends SimpleChannelInboundHandler<MyDataInfo.Student> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.Student msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        MyDataInfo.Student student = MyDataInfo.Student.newBuilder()
                                                        .setName("余志友")
                                                        .setAge(18)
                                                        .setAddress("hangzhou")
                                                        .build();
        MyDataInfo.Dog dog = MyDataInfo.Dog.newBuilder()
                                            .setName("狗狗")
                                            .setAge(11)
                                            .build();

        MyDataInfo.Cat cat = MyDataInfo.Cat.newBuilder()
                                            .setName("猫猫")
                                            .setAge(11)
                                            .setCity("shanghai")
                                            .build();

        int randomInt = new Random().nextInt(3);
        MyDataInfo.MyMessage myMessage = null;
        switch (randomInt) {
            case 0:
                myMessage = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.StudentType)
                        .setStudent(student).build();
                break;
            case 1:
                myMessage = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.DogType)
                        .setDog(dog).build();
                break;
            case 2:
                myMessage = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.CatType)
                        .setCat(cat).build();
                break;
        }

        Channel channel = ctx.channel();
        channel.writeAndFlush(myMessage);
    }
}
