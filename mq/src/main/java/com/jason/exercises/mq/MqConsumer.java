package com.jason.exercises.mq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by shanshouchen@weibangong.com on 2017/1/23.
 */
public class MqConsumer {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws InterruptedException, TimeoutException, IOException {
        consumer();
    }

    public static void consumer() throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("103.235.225.31");
        factory.setPort(15672);
        factory.setUsername("wbgrmq");
        factory.setPassword("wbgrmq");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        final Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                try {
                    System.out.println(envelope.getDeliveryTag());

                    System.out.println(1 / 0);//try to throw Runtime Exception

                    channel.basicAck(envelope.getDeliveryTag(), false);
                } catch (Exception e) {
                    channel.basicNack(envelope.getDeliveryTag(), false, true);
                }
            }
        };


        channel.basicConsume(QUEUE_NAME, false, consumer);
    }
}
