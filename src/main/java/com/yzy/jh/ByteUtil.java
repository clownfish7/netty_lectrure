package com.yzy.jh;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Objects;

public class ByteUtil {


    private final static Charset GBK = Charset.forName("GBK");

    private final static byte[] EMPTY = new byte[0];

    /**
     * int转dword（4字节）
     * @param value
     * @return
     */
    public static byte[] int2DWORD(long value) {
        byte byte0 = (byte) ((value >> 24) & 0xff);
        byte byte1 = (byte) ((value >> 16) & 0xff);
        byte byte2 = (byte) ((value >> 8) & 0xff);
        byte byte3 = (byte) (value & 0xff);

        return new byte[] {byte0, byte1, byte2, byte3};

    }

    /**
     * int转word（2字节）
     * 取后两个字节
     * @param value
     * @return
     */
    public static byte[] int2WORD(int value) {
        byte byte2 = (byte) ((value >> 8) & 0xff);
        byte byte3 = (byte) (value & 0xff);

        return new byte[]{byte2, byte3};
    }

    /**
     * int转byte
     * 取最后字节
     * @param value
     * @return
     */
    public static byte int2BYTE(int value) {
        return (byte) (value & 0xff);
    }

    /**
     * string转字节数组
     * GBK编码
     * @param value
     * @return
     */
    public static byte[] string2Bytes(String value) {
        return value == null ? EMPTY : value.getBytes(GBK);
    }

    /**
     * word转字节数组
     * @param bytes
     * @return
     */
    public static int WORD2Int(byte[] bytes) {

        if (bytes.length < 2)  throw new RuntimeException("数组长度小于2");

        return ((bytes[0] & 0xFF) << 8) | (bytes[1] & 0xFF);
    }

    /**
     * DWORD转字节数组
     * @param bytes
     * @return
     */
    public static int DWORD2Int(byte[] bytes){
        if (bytes.length < 4)  throw new RuntimeException("数组长度小于4");

        return ((bytes[0] & 0xFF) << 24) | ((bytes[1] & 0xFF) << 16) | ((bytes[2] & 0xFF) << 8) | (bytes[3] & 0xFF);
    }

    /**
     * 字节数组转string
     * @param bytes
     * @return
     */
    public static String toString(byte[] bytes){
        return new String(bytes, GBK);
    }

    /**
     * 最大支持32位
     * @param value
     * @param offset
     * @param len
     * @return
     */
    public static String toBinaryString(int value, int offset, int len){
        return Long.toBinaryString(value & 0xffffffffL | 0x100000000L).substring(offset + 1, offset + 1 + len);
    }

    /**
     * 去掉末尾为0字节
     * @param source
     * @return
     */
    public static byte[] rightTrim(byte[] source) {
        Objects.requireNonNull(source);
        int i = source.length - 1;
        while (i >= 0 && source[i] == 0) {
            --i;
        }
        return Arrays.copyOf(source, i + 1);
    }

    /**
     * 去掉开头为0字节
     * @param source
     * @return
     */
    public static byte[] leftTrim(byte[] source) {
        Objects.requireNonNull(source);
        int i = 0;
        int len = source.length;
        while (i < len && source[i] == 0) {
            ++i;
        }
        return Arrays.copyOfRange(source, i, len);
    }

}
