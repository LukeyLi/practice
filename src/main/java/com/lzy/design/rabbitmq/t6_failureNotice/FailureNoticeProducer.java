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
public class FailureNoticeProducer {
    public static final String EXCHANGE_NAME  = "failureNotice_exchange";
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");

        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();
        channel.exchangeDeclare(FailureNoticeProducer.EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        channel.addReturnListener(new ReturnListener() {
            @Override
            public void handleReturn(int replyCode, String replyText, String exchange, String routingKey, AMQP.BasicProperties properties, byte[] body) throws IOException {
                log.info("send message error, replyCode: {}, replyText: {}, exchange: {}, routingKey: {}",
                        replyCode, replyText, exchange, routingKey);
            }
        });
        String[] logLevel = {"error","info"};
        for (int i = 0; i < 5; i++) {
            String routingKey = logLevel[i % 2];
            String message = "hello rabbitmq " + i;
            channel.basicPublish(EXCHANGE_NAME, routingKey,  true, null, message.getBytes());
            log.info("send message, routingKey: {}, message: {}", routingKey, message);
        }
    }
}
