package com.lzy.design.rabbitmq.t4_autoAckfalse;

import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description:
 * 一般情况下，如果队列中的消息发送到消费者后，消费者不对消息进行确认,
 * 那么消息会一直留在队列中, 直到确认才会删除。
 * 消费者与rabbitMQ的连接中断, rabbitMQ才会考虑将消息重新投递给另一个消费者
 *
 * 我们可以通过如下步骤来演示
 * 1.开启 AutoAckFalseConsumerA, AutoAckFalseConsumerB, RejectMsgProducer
 * 2.此时 AutoAckFalseConsumerA, AutoAckFalseConsumerB 都会收到消息, 但是AutoAckFalseConsumerA没有对消息进行确认
 * 3.关闭 AutoAckFalseConsumerA, 此时可以看到AutoAckFalseConsumerB又收到AutoAckFalseConsumerA收到的消息
 * @author: lzy
 * @create: 2020-01-31 11:19
 **/
@Slf4j
public class AutoAckFalseProducer {
    public static final String EXCHANGE_NAME = "ackFalse_exchange";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localHost");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        channel.confirmSelect();
        channel.addConfirmListener(new ConfirmListener() {
            @Override
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                log.info("handleAck, deliveryTag: {}, multiple: {}", deliveryTag, multiple);
            }

            @Override
            public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                log.info("handleNack, deliveryTag: {}, multiple: {}", deliveryTag, multiple);
            }
        });

        String routingKey = "error";
        for (int i = 0; i < 100; i++) {
            String message = "hello rabbitmq " + i;
            channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes());
            log.info("send message, routingKey: {}, message: {}", routingKey ,message);
        }
    }
}
