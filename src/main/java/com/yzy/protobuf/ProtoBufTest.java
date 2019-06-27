package com.yzy.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @author yzy
 * @classname ProtoBufTest
 * @description TODO
 * @create 2019-06-27 11:01
 */
public class ProtoBufTest {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        DataInfo.Student student = DataInfo.Student.newBuilder()
                .setName("余志友")
                .setAge(18)
                .setAddress("hangzhou")
                .build();

        byte[] bytes = student.toByteArray();

        DataInfo.Student student1 = DataInfo.Student.parseFrom(bytes);

        System.out.println(student1);

        System.out.println(student1.getName());
        System.out.println(student1.getAddress());
        System.out.println(student1.getAge());

    }
}
