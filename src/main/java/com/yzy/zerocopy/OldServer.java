package com.yzy.zerocopy;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author yzy
 * @classname OldServer
 * @description TODO
 * @create 2019-07-02 16:43
 */
public class OldServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8899);
        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            try {

                byte[] byteArray = new byte[4096];

                while (dataInputStream.read(byteArray,0,byteArray.length) > 0) {

                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
