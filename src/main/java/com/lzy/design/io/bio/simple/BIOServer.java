package com.lzy.design.io.bio.simple;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * 阻塞点：1.获取套接字，accept 2.
 * @author: lzy
 * @create: 2020-04-14 16:24
 **/
public class BIOServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10001);
        System.out.println("启动BIO服务!");
        while (true) {
            //3.accepet接收连接，阻塞
            final Socket socket = serverSocket.accept();
            System.out.println("客户端连接了");
            //业务逻辑处理，写回数据到socket连接中。

            OutputStream outputStream = socket.getOutputStream();
            String sendMsg = "嘻嘻嘻嘻";
            outputStream.write(sendMsg.getBytes());
            //读取客户端传输过来的数据
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int read = inputStream.read(bytes);
            if (read != -1) {
                System.out.println("客户端：" + new String(bytes, 0, read));
            } else {
                break;
            }

        }
    }


}
