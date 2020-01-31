package com.lzy.design.rabbitmq.t4_autoAckfalse;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-31 15:33
 **/
@Slf4j
public class BatchAckConsumer extends DefaultConsumer {
    private int count = 0;

    public BatchAckConsumer(Channel channel) {
        super(channel);
    }

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body) throws IOException {
        String message = new String(body, "UTF-8");
        count++;
        if (count == Integer.MAX_VALUE) {
            count = 0;
        }
        if (count % 50 == 0) {
            this.getChannel().basicAck(envelope.getDeliveryTag(), true);
        }
        log.info("get message, routingKey: {}, message: {}", envelope.getRoutingKey() ,message);
    }
}
