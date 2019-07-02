package com.yzy.nio;

import java.io.*;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * @author yzy
 * @classname NioTest13
 * @description TODO
 * @create 2019-07-02 13:16
 */
public class NioTest13 {
    public static void main(String[] args) throws IOException {
        String fileIn = "NioTest13_in.txt";
        String fileOut = "NioTest13_out.txt";

        RandomAccessFile fileInput = new RandomAccessFile(fileIn, "r");
        RandomAccessFile fileOutput = new RandomAccessFile(fileOut, "rw");

        long length = new File(fileIn).length();

        FileChannel channelIn = fileInput.getChannel();
        FileChannel channelOut = fileOutput.getChannel();

        MappedByteBuffer mappedByteBuffer = channelIn.map(FileChannel.MapMode.READ_ONLY, 0, length);
        Charset charset = Charset.forName("iso-8859-1");
        CharsetDecoder decode = charset.newDecoder();
        CharsetEncoder encode = charset.newEncoder();

        CharBuffer charBuffer = decode.decode(mappedByteBuffer);
        ByteBuffer byteBuffer = encode.encode(charBuffer);

        channelOut.write(byteBuffer);

        fileInput.close();
        fileOutput.close();

    }
}
