package com.lzy.design.io.bio.multi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * @description:
 * @author: lzy
 * @create: 2020-04-15 22:37
 **/
public class SeverHandler implements Runnable {

    private Socket socket;

    public SeverHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            //获取socket 读写
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            //处理数据
            String readMsg = reader.readLine();
            if (readMsg != null && readMsg != "") {
                System.out.println("客户端发来消息：" + readMsg);
                writer.println(new Date().toString() + ",我收到了消息");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer != null) {
                writer.close();
            }
            if (socket != null) {
                try {
                    System.out.println("客户端断开连接");
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
