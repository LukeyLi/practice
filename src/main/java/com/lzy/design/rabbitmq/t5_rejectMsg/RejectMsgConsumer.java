package com.lzy.design.rabbitmq.t5_rejectMsg;

import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description:
 * 消息拒绝有两种api
 * 1.channel.basicReject(envelope.getDeliveryTag(), false);
 * 2.channel.basicNack(envelope.getDeliveryTag(), false, false);
 * 这两种方式的区别在于basicNack有一个批量拒绝的功能
 * requeue为true时, 消息会重新投发给任意一个消费者（包括拒绝消息的那个消费者）
 * @author: lzy
 * @create: 2020-01-31 19:22
 **/
@Slf4j
public class RejectMsgConsumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(RejectMsgProducer.EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        String queueName = "errorQueue";
        channel.queueDeclare(queueName, false, false, false, null);
        String bindingKey = "error";
        channel.queueBind(queueName, RejectMsgProducer.EXCHANGE_NAME, bindingKey);

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                try {
                    throw new RuntimeException("消息消费异常");
                } catch (Exception  e) {
                    channel.basicReject(envelope.getDeliveryTag(), true);
//                    channel.basicNack(envelope.getDeliveryTag(), false, true);
                }
                log.info("get message, routingKey: {}, message: {}", envelope.getRoutingKey() ,message);
            }
        };
        channel.basicConsume(queueName, false, consumer);
    }
}
