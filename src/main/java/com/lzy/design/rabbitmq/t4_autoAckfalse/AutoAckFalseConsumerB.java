package com.lzy.design.rabbitmq.t4_autoAckfalse;

import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-31 11:57
 **/

@Slf4j
public class AutoAckFalseConsumerB {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(AutoAckFalseProducer.EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

        String queueName = "errorQueue";
        channel.queueDeclare(queueName, false, false, false,null);
        String bindingKey = "error";
        channel.queueBind(queueName, AutoAckFalseProducer.EXCHANGE_NAME, bindingKey);
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                try {
                    //当我们正常消息，手动ack后，消息就会从map中删除
                    //multiple为false表示一条一条确认
                    channel.basicAck(envelope.getDeliveryTag(), false);
                } catch (Exception e) {
                    // 发生异常, 发送nack,根据requeue参数来决定是将消息丢弃开始还是再重新放回队列
                    channel.basicNack(envelope.getDeliveryTag(), false, false);
                }
                log.info("get message, routingKey: {}, message: {}", envelope.getRoutingKey() ,message);
            }
        };
        channel.basicConsume(queueName, false, consumer);
    }
}
