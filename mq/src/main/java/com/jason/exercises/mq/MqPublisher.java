package com.jason.exercises.mq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * Created by shanshouchen@weibangong.com on 2017/1/23.
 */
public class MqPublisher {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        publish();
    }

    public static void publish() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("103.235.225.31");
        factory.setPort(15672);
        factory.setUsername("wbgrmq");
        factory.setPassword("wbgrmq");

        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();

        Map<String, Object> args = new HashMap<>();
        args.put("x-expires", 10*1000);//队列超时设置

        channel.queueDeclare(QUEUE_NAME, false, false, false, args);
//        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        String message = "Hello World!!";

        AMQP.BasicProperties properties = new AMQP.BasicProperties()
                .builder()
                .expiration("" + (1000 * 6))
                .build();


        channel.basicPublish("", QUEUE_NAME, properties, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
        channel.close();
        connection.close();
    }
}
