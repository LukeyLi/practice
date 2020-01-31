package com.lzy.design.rabbitmq.t6_failureNotice;

import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-31 19:55
 **/

@Slf4j
public class FailureNoticeConsumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");

        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();

        channel.exchangeDeclare(FailureNoticeProducer.EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

        String queueName = "failureNoticeQueue";
        String bindingKey = "error";
        channel.queueDeclare(queueName, false, false, false ,null);
        channel.queueBind(queueName, FailureNoticeProducer.EXCHANGE_NAME, bindingKey);
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                log.info("get message, routingKey: {}, message: {}", envelope.getRoutingKey() ,message);
            }
        };
        channel.basicConsume(queueName , true, consumer);
    }
}
