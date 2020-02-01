package com.lzy.design.rabbitmq.t8_backupExchange;

import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-31 23:15
 **/
@Slf4j
public class MainConsumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(BackupExProducer.BAK_EXCHANGE_NAME, BuiltinExchangeType.FANOUT);

        Map<String, Object> argsMap = new HashMap<>();
        argsMap.put("alternate-exchange", BackupExProducer.BAK_EXCHANGE_NAME);

        channel.exchangeDeclare(BackupExProducer.EXCHANGE_NAME, BuiltinExchangeType.DIRECT, false, false, argsMap);

        String queueName = "errorQueue";
        channel.queueDeclare(queueName, false, false, false, null);
        String bindingKey = "error";
        channel.queueBind(queueName, BackupExProducer.EXCHANGE_NAME, bindingKey);
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
