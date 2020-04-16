package com.lzy.design.io.bio.simple;

import java.io.*;
import java.net.*;

/**
 * @description:
 * @author: lzy
 * @create: 2020-04-14 20:50
 **/
public class BIOClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        byte[] bytes = new byte[1024];
        socket.setSoTimeout(30000); //超时时间
        socket.connect(new InetSocketAddress(InetAddress.getLocalHost(), 10001), 30000);

        System.out.println("已发起链接");
        System.out.println("客户端,IP:" + socket.getLocalAddress() + ",port:" + socket.getLocalPort());
        System.out.println("服务器,IP:" + socket.getInetAddress() + ",port:" + socket.getPort());

        //客户端发送数据给服务端
        OutputStream outputStream = socket.getOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        printStream.printf("嘿嘿嘿嘿嘿");

        //客户端从socket读取
        InputStream inputStream = socket.getInputStream();
        while (true) {
            int read = inputStream.read(bytes);
            if (read != -1) {
                System.out.println("服务端：" + new String(bytes, 0, read));
            } else {
                break;
            }
        }

    }

}
