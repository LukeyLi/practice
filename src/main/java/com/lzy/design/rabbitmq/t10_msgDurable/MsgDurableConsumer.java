package com.lzy.design.rabbitmq.t10_msgDurable;

import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description:
 * @author: lzy
 * @create: 2020-02-01 13:20
 **/
@Slf4j
public class MsgDurableConsumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setVirtualHost("/");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(MsgDurableProducer.EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

        String queueName = "msgDurableQueue";
        channel.queueDeclare(queueName, true, false, false, null);

        channel.queueBind(queueName, MsgDurableProducer.EXCHANGE_NAME, "error");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                log.info("get message, routingKey: {}, message: {}", envelope.getRoutingKey(), message);
            }
        };
        channel.basicConsume(queueName, true, consumer);
    }
}
