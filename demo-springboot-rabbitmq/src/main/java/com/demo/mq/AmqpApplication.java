package com.demo.mq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * amqp协议的rabbitmq与springboot的整合
 *
 * 自动配置
 * 1。RabbitAutoConfiguration
 * 2。有自动配置了连接工厂ConnectionFactory
 * 3。RabbitProperties封装了Rabbitmq的配置
 * 4。RabbitTemplate给rabbitmq发送和接收消息
 * 5。AmqpAdmin：rabbitmq系统管理功能组件
 *      AmqpAdmin:创建和删除 Queue Exchange Binding
 * 6。@EnableRabbit + @RabbitListener 监听消息队列的内容
 *
 * @author qichengjian
 */
/**开启基于注解的RabbitMq模式**/
@EnableRabbit
@SpringBootApplication
public class AmqpApplication {
    public static void main(String[] args) {
        SpringApplication.run(AmqpApplication.class, args);
    }
}
