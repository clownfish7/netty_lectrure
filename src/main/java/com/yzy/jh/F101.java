package com.yzy.jh;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Base64;

/**
 * @author yzy
 * @classname F101
 * @description TODO
 * @create 2019-11-04 17:00
 */
public class F101 {
    private int type;
    private String ip;
    private int tcpPort;
    private int udpPort;

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

    public int getTcpPort() {
        return tcpPort;
    }

    public void setTcpPort(int tcpPort) {
        this.tcpPort = tcpPort;
    }

    public int getUdpPort() {
        return udpPort;
    }

    public void setUdpPort(int udpPort) {
        this.udpPort = udpPort;
    }

    public String encode() {
        byte[] ipBytes = ip.getBytes(Charset.forName("gbk"));
        int length = 1 + 1 + ipBytes.length + 4 + 4 + 4;
        ByteBuf bf = Unpooled.buffer(length);
        bf.writeByte(type);
        bf.writeByte(ipBytes.length);
        bf.writeBytes(ipBytes);
        bf.writeBytes(ByteUtil.int2DWORD(tcpPort));
        bf.writeBytes(ByteUtil.int2DWORD(udpPort));
        bf.writeByte(0);
        bf.writeByte(0);
        bf.writeByte(0);
        bf.writeByte(0);

        byte[] bytes = new byte[length];
        bf.readBytes(bytes);
        return getCode(bytes);
    }

    public String encode2() {
        byte[] ipBytes = ip.getBytes(Charset.forName("gbk"));
        int length = 1 + 1 + ipBytes.length + 4 + 4 + 4;
        ByteBuffer bf = ByteBuffer.allocate(length);
        bf.put((byte) type);
        bf.put((byte) ipBytes.length);
        bf.put(ipBytes);
        bf.putInt(tcpPort);
        bf.putInt(udpPort);
        bf.putInt(0);

        byte[] bytes = new byte[length];
        bf.flip();
        bf.get(bytes);
        return getCode(bytes);
    }

    private String getCode(byte[] bytes) {
        return new String(Base64.getEncoder().encode(bytes));
    }


    private static final char HexCharArr[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

    private static final String HexStr = "0123456789abcdef";

    public static String byteArrToHex(byte[] btArr) {
        char strArr[] = new char[btArr.length * 2];
        int i = 0;
        for (byte bt : btArr) {
            strArr[i++] = HexCharArr[bt>>>4 & 0xf];
            strArr[i++] = HexCharArr[bt & 0xf];
        }
        return new String(strArr);
    }

    public static byte[] hexToByteArr(String hexStr) {
        char[] charArr = hexStr.toCharArray();
        byte btArr[] = new byte[charArr.length / 2];
        int index = 0;
        for (int i = 0; i < charArr.length; i++) {
            int highBit = HexStr.indexOf(charArr[i]);
            int lowBit = HexStr.indexOf(charArr[++i]);
            btArr[index] = (byte) (highBit << 4 | lowBit);
            index++;
        }
        return btArr;
    }
}
