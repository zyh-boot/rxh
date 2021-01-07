package com.rxh.complat.common.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

//@Component
public class QueueConsumerListener {
    //queue模式的消费者 destination 指定要消费哪个消息队列, 就是我们在生产消息时自定义的队列名
    //containerFactory 指定生成JMS监听的工厂 也就是消息的监听器 在之前ActiviteMqConfig中设置的
    @JmsListener(destination = "${spring.activemq.queue-name}", containerFactory = "queueListener")
    public void readActiveQueue(String message) {
        System.out.println("queue接受到：" + message);
    }
}