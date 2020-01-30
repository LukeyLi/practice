package com.lzy.design.rabbitmq.t1_quickstart;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-30 12:53
 **/

@Slf4j
public class QuickStartProducer {
    public static final String EXCHANGE_NAME =  "quickStart_exchange";

    public static void main(String[] args) throws IOException, TimeoutException {
        //1.创建ConnectFactory 并进行配置
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(
                5672);
        connectionFactory.setVirtualHost("/");
        //2 获取连接
        Connection connection = connectionFactory.newConnection();
        //3. 通过connection创建一个channel
        Channel channel = connection.createChannel();

        //4.创建交换机
        // 因为不知道生产者和消费者程序哪个先启动，所以一般的做法是在生产者和消费者2边都创建交换器（有的话不会重复创建）
        channel.exchangeDeclare(QuickStartProducer.EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

        String routingKey = "error";
        //5.通过channel发送数据
        for (int i = 0; i < 5; i++) {
            String message = "hello rabbitmq" + i;
            channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes());
            log.info("send message, routingKey: {}, message: {}", routingKey, message);
        }
        //6.关闭相关连接
        channel.close();
        connection.close();

    }
}
