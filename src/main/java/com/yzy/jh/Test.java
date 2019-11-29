package com.yzy.jh;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.sql.SQLOutput;
import java.util.Base64;

/**
 * @author yzy
 * @classname Test
 * @description TODO
 * @create 2019-11-04 17:10
 */
public class Test {
    public static void main(String[] args) {
        f101();
        f200();
        f331();

        byte[] bys = "http://47.97.8.7:8080/ponysafety2/driver_face/FACEIDSJ001/330998201910290001.jpg".getBytes(Charset.forName("gbk"));
        byte[] bys2 = "刘亮辉".getBytes(Charset.forName("gbk"));
        byte[] bys22 = "刘亮辉".getBytes(Charset.forName("utf-8"));
        byte[] bys3 = "6刘清川".getBytes(Charset.forName("gbk"));
        System.out.println(bytesToHexString(bys));
        System.out.println("刘亮辉 - gbk  " +bytesToHexString(bys2));
        System.out.println("刘亮辉 - utf8 " +bytesToHexString(bys22));
        System.out.println(bytesToHexString(bys3));

        String aa = "AAEBATIAPAAePAABLAfQAQAAAAAFAQAAAAAFBgAAAAA=";
        String bb = "AAEBAVAAPAhmYWNlZmFjZR48AQJYB9ABAAAAAQUBAAAAAQUGAAAAAA==";
        byte[] bytes = Base64.getDecoder().decode(aa);
        byte[] bytes2 = Base64.getDecoder().decode(bb);
        System.out.println(bytesToHexString(bytes));
        System.out.println(bytesToHexString(bytes2));

        System.out.println("----------------------------------");
        notification();
        parse();

        System.out.println("========================================");
//        ["F101=AQk0Ny45Ny44LjcAAB+YAAAAAA==","F200=AAEBATIAPAAePAAAHgfQAQAAAAAFAQAAAAAFBgAAAAA=","F331=AAk0Ny45Ny44LjcAAB+YBmRyaXZlcg==","F100=CTQ3Ljk3LjguNwAAH5gGZHJpdmVy"]}
        System.out.println(bytesToHexString(Base64.getDecoder().decode("AAk0Ny45Ny44LjcAAB+YBmRyaXZlcg==")));
        System.out.println(bytesToHexString(Base64.getDecoder().decode("CTQ3Ljk3LjguNwAAH5gGZHJpdmVy")));
    }

    private static void f101() {
        F101 f101 = new F101();
        f101.setType(1);
        f101.setIp("47.97.8.7");
        f101.setTcpPort(8088);
        f101.setUdpPort(0);
        System.out.println(f101.encode());
        System.out.println(f101.encode2());
    }

    private static void f200() {
        F200 f200 = new F200();
        f200.setLogicChannel(0);
        f200.setEnableFaceCheck(1);
        f200.setEnableFaceComparison(1);
        f200.setEnableFaceUpload(1);
        f200.setFaceComparisonConfidence(80);
        f200.setAlarmPromptingMode(1);
        f200.setFaceCheckResultPromptVolume(60);
        f200.setFaceCheckResultContent("faceface");
        f200.setFaceCheckBeginSpeed(30);
        f200.setFaceCheckEndSpeed(60);
        f200.setFaceCheckTriggerStrategy(1);
        f200.setFaceCheckTimeInterval(15);
        f200.setFaceCheckDistanceInterval(2000);
        f200.setEnableTakePicUpload(1);
        f200.setTakePicUploadLogicChannel(1);
        f200.setPicResolutionRatio(5);
        f200.setEnableTakeVedioUpload(1);
        f200.setTakeVedioUploadLogicChannel(1);
        f200.setAlarmTakeVedioTime(5);
        f200.setVedioResolutionRatio(6);
        System.out.println(f200.encode());
        System.out.println(f200.encode2());
    }

    private static void f331() {
        F331 f331 = new F331();
        f331.setType(0);
        f331.setIp("47.97.8.7");
        f331.setPort(8088);
        f331.setContext("driver");
        System.out.println(f331.encode());
        System.out.println(f331.encode2());
    }

    public static String bytesToHexString(byte[] bArr) {
        StringBuffer sb = new StringBuffer(bArr.length);
        String sTmp;

        for (int i = 0; i < bArr.length; i++) {
            sTmp = Integer.toHexString(0xFF & bArr[i]);
            if (sTmp.length() < 2)
                sb.append(0);
            sb.append(sTmp.toUpperCase());
        }

        return sb.toString();
    }

    private static void notification() {
        System.out.println("==========驾驶员分组变更通知===========");
        JSONObject obj = new JSONObject();
        JSONObject data = new JSONObject();
        data.put("groupIndexCode", 1);
        obj.put("infoType", 1);
        obj.put("status", 3);
        obj.put("extraCondition", data);

        byte[] gbks = obj.toString().getBytes(Charset.forName("gbk"));
        System.out.println(new String(Base64.getEncoder().encode(gbks),Charset.forName("gbk")));

        byte[] bbb = Base64.getDecoder().decode(new String(Base64.getEncoder().encode(gbks),Charset.forName("gbk")));
        System.out.println(new String(bbb, Charset.forName("gbk")));
        System.out.println(bytesToHexString(gbks));

        System.out.println("==========驾驶员信息变更通知===========");
        JSONObject obj1 = new JSONObject();
        JSONObject data1 = new JSONObject();
        JSONArray arr = new JSONArray();
//        arr.add(4);
        arr.add(5290);
        data1.put("groupIndexCode", 1);
        data1.put("driverIndexCodeArray", arr);
        obj1.put("infoType", 2);
        obj1.put("status", 0);
        obj1.put("extraCondition", data1);

        byte[] gbks1 = obj1.toString().getBytes(Charset.forName("gbk"));
        System.out.println(new String(Base64.getEncoder().encode(gbks1),Charset.forName("gbk")));
        byte[] bbb1 = Base64.getDecoder().decode(new String(Base64.getEncoder().encode(gbks1),Charset.forName("gbk")));
        System.out.println(new String(bbb1, Charset.forName("gbk")));


    }

    private static void parse() {
        byte[] wtf = "eyAiZHJpdmVySW5kZXhDb2RlIjogNTI5MCwgIm5hbWUiOiAiNuWImOa4heW3nSIsICJzZXgiOiAwLCAiY2FyZFR5cGUiOiAwLCAiY2FyZElEIjogIjMzMDM4MjE5OTcwODA2MDAwMiIsICJwaG90b1VybCI6ICJodHRwOlwvXC80Ny45Ny44Ljc6ODA4MFwvcG9ueXNhZmV0eTJcL2RyaXZlcl9mYWNlXC9GQUNFSURTSjAwMVwvMzMwOTk4MjAxOTEwMjkwMDAxLmpwZyIsICJkcml2ZXJWZXJzaW9uIjogMSB9AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA="
                .getBytes(Charset.forName("utf-8"));
        String ss = new String(Base64.getDecoder().decode(wtf),Charset.forName("utf-8"));
        JSONObject s1 = JSON.parseObject(ss);
        System.out.println(s1);
    }
}