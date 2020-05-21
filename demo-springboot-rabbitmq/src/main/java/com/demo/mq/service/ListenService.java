package com.demo.mq.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * 使用注解来监听rabbitmq消息
 * @author qichengjian
 */
@Service
public class ListenService {

    @RabbitListener(queues = "student.news")
    public void receive(Object object) {
        System.out.println("接收到的消息："+object);
    }

    @RabbitListener(queues = {"news"})
    public void receive02(Message message) {
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
