package com.yzy.jh;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Base64;

/**
 * @author yzy
 * @classname F331
 * @description TODO
 * @create 2019-11-04 17:16
 */
public class F331 {
    private int type;
    private String ip;
    private int port;
    private String context;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String encode() {
        byte[] ipBytes = ip.getBytes(Charset.forName("gbk"));
        byte[] contextBytes = context.getBytes(Charset.forName("gbk"));
        int length = 1 + 1 + ipBytes.length + 4 + 1 + contextBytes.length;
        ByteBuf byteBuf = Unpooled.buffer(length);
        byteBuf.writeByte(type);
        byteBuf.writeByte(ipBytes.length);
        byteBuf.writeBytes(ipBytes);
        byteBuf.writeBytes(ByteUtil.int2DWORD(port));
        byteBuf.writeByte(contextBytes.length);
        byteBuf.writeBytes(contextBytes);
        byte[] bytes = new byte[length];
        byteBuf.readBytes(bytes);
        return getCode(bytes);
    }

    public String encode2() {
        byte[] ipBytes = ip.getBytes(Charset.forName("gbk"));
        byte[] contextBytes = context.getBytes(Charset.forName("gbk"));
        int length = 1 + 1 + ipBytes.length + 4 + 1 + contextBytes.length - 1;
        ByteBuffer bf = ByteBuffer.allocate(length);
//        bf.put((byte) type);
        bf.put((byte) ipBytes.length);
        bf.put(ipBytes);
        bf.putInt(port);
        bf.put((byte) contextBytes.length);
        bf.put(contextBytes);
        byte[] bytes = new byte[length];
        bf.flip();
        bf.get(bytes);
        return getCode(bytes);
    }

    private String getCode(byte[] bytes) {
        return new String(Base64.getEncoder().encode(bytes));
    }
}
