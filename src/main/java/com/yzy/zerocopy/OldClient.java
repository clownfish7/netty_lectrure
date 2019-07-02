package com.yzy.zerocopy;

import java.io.*;
import java.net.Socket;

/**
 * @author yzy
 * @classname OldClient
 * @description TODO
 * @create 2019-07-02 16:49
 */
public class OldClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8899);
        File file = new File("D:\\y2y\\01A.rar");

        InputStream inputStream = new FileInputStream(file);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        byte[] buffer = new byte[4096];
        long readCount;
        long total = 0;

        long starttime = System.currentTimeMillis();

        while ((readCount = inputStream.read(buffer)) >= 0) {
            total += readCount;
            dataOutputStream.write(buffer);
        }

        System.out.println("发送总字节数：" + total + ", 耗时: " + (System.currentTimeMillis() - starttime));

        inputStream.close();
        dataOutputStream.close();
        socket.close();
    }
}
