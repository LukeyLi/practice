package com.lzy.design.io.bio.multi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * 比较simple:
 * 1.
 * @author: lzy
 * @create: 2020-04-15 22:36
 **/
public class BIOServer {

    public static final int SEVER_PROT = 10001;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        ExecutorService executorService = null;
        try {
            serverSocket = new ServerSocket(SEVER_PROT);
            System.out.println("启动BIO服务!");

            // 每一个新的连接都创建一个线程，负责读取数据
            executorService = Executors.newFixedThreadPool(10);
            while (true) {
                Socket socket = null;
                try {
                    socket = serverSocket.accept();
                    System.out.println("客户端连接了");

                    executorService.submit(new SeverHandler(socket));
                    //new Thread(new SeverHandler(socket)).start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
            if(serverSocket !=null){
                System.out.println("socket服务关闭");
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
