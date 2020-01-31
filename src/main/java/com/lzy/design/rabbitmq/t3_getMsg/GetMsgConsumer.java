package com.lzy.design.rabbitmq.t3_getMsg;

import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-30 19:43
 **/
@Slf4j
public class GetMsgConsumer {
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(GetMsgProducer.EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

        String queueName = "errorQueue";
        channel.queueDeclare(queueName, false, false, false, null);
        channel.queueBind(queueName, GetMsgProducer.EXCHANGE_NAME, "error");

        while(true) {
            GetResponse getResponse = channel.basicGet(queueName, true);
            if (null != getResponse) {
                log.info("get message, routingKey: {}, message: {}", getResponse.getEnvelope().getRoutingKey(), new String(getResponse.getBody()));
            }
            Thread.sleep(1000);
        }
    }
}
