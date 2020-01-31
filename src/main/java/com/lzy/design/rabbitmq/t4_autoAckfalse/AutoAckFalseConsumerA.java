package com.lzy.design.rabbitmq.t4_autoAckfalse;

import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-31 11:56
 **/
@Slf4j
public class AutoAckFalseConsumerA {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setVirtualHost("/");
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(AutoAckFalseProducer.EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        String queueName = "errorQueue";
        channel.queueDeclare(queueName, false, false, false, null);
        String bindingKey = "error";
        channel.queueBind(queueName, AutoAckFalseProducer.EXCHANGE_NAME, bindingKey);

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                log.info("get message, routingKey: {}, message: {}", envelope.getRoutingKey() ,message);
            }
        };
        channel.basicConsume(queueName, false, consumer);
    }
}
