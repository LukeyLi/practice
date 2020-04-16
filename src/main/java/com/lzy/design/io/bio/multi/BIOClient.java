package com.lzy.design.io.bio.multi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @description:
 * @author: lzy
 * @create: 2020-04-15 22:53
 **/
public class BIOClient {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            socket = new Socket("127.0.0.1", BIOServer.SEVER_PROT);
            System.out.println("已发起链接");
            System.out.println("客户端,IP:" + socket.getLocalAddress() + ",port:" + socket.getLocalPort());
            System.out.println("服务器,IP:" + socket.getInetAddress() + ",port:" + socket.getPort());
            //获取socket 读写
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            //写数据
            writer.println("嘻嘻，你好啊");
            //读数据
            String severMsg = reader.readLine();
            if (severMsg != null) {
                System.out.println("服务端：" + severMsg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer != null) {
                writer.close();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
