package com.lzy.design.io.nio;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: lzy
 * @create: 2020-04-16 17:11
 **/
public class NIOServer {

    public static final int SEVER_PROT = 10001;

    public static void main(String[] args) {
        Selector selector = null;
        ServerSocketChannel channel = null;
        try {
            // 1.init
            selector = Selector.open();
            channel = ServerSocketChannel.open();
            //指定serverSocketChannel指定的ServerSocket绑定指定端口
            channel.socket().bind(new InetSocketAddress(SEVER_PROT));
            // 将通道设置为非阻塞
            channel.configureBlocking(false);
            //通道（channel）注册到 通道管理器 Selector，为selectionKey.OP_ACCEPT事件
            channel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("NIO服务器启动");

            ExecutorService executorService = Executors.newFixedThreadPool(10);
            executorService.submit(new NIOSeverHandler(selector));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
