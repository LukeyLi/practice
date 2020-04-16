package com.lzy.design.io.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * @description:
 * @author: lzy
 * @create: 2020-04-16 18:16
 **/
public class NIOSeverHandler implements Runnable {

    private Selector selector;

    public NIOSeverHandler(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void run() {
        while (true) {
            //阻塞
            try {
                selector.select();
                //获取监听事件
                Set<SelectionKey> selectionKeys = selector.keys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();

                SelectionKey key = null;
                while (iterator.hasNext()) {
                    key = iterator.next();
                    try {
                        handler(key);
                    } catch (Exception e) {
                        if (key != null) {
                            if (key.channel() != null) {
                                key.channel().close();
                            }
                            key.cancel();
                        }
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private void handler(SelectionKey key) throws IOException {
        if (key.isValid()) {
            if (key.isAcceptable()) {
                ServerSocketChannel severChannel = (ServerSocketChannel) key.channel();
                SocketChannel socketChannel = severChannel.accept();
                socketChannel.configureBlocking(false);

                severChannel.register(selector, SelectionKey.OP_ACCEPT);
            }
            if (key.isReadable()) {
                SocketChannel socketChannel = (SocketChannel) key.channel();

                handleRead(socketChannel);
            }
            if (key.isWritable()) {

            }
        }
    }

    private void handleRead(SocketChannel socketChannel) throws IOException {

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int readBytes = socketChannel.read(buffer);
        if (readBytes > 0) {
            buffer.flip();
            byte[] bytes = new byte[buffer.remaining()];
            //将缓冲区的可读字节复制到新字节数组
            buffer.get(bytes);
            String msg = new String(bytes);
            System.out.println("服务端收到：" + msg);

            String respMsg = new Date().toString() + " 我收到该消息了";
            handleWrite(socketChannel, respMsg);

        } else if (readBytes < 0) {
            socketChannel.close();
        }
    }
    private void handleWrite(SocketChannel socketChannel, String msg) throws IOException {
        if (msg != null && msg.trim().length() > 0) {
            byte[] msgBytes = msg.getBytes();
            ByteBuffer buffer = ByteBuffer.allocate(msgBytes.length);
            buffer.put(msgBytes);
            buffer.flip();
            socketChannel.write(buffer);
        }
    }


}
