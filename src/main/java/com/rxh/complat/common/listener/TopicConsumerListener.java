package com.rxh.complat.common.listener;

import com.rxh.complat.constant.MqConstant;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.TextMessage;

@Component
public class TopicConsumerListener {
    //topic模式的消费者
    @JmsListener(destination = MqConstant.TEST, containerFactory = "topicListenertest")
    public void readActiveQueue(String message, TextMessage textMessage) {
        System.out.println("topic接受到：test" + message);
    } //topic模式的消费者

    @JmsListener(destination = MqConstant.ZYH, containerFactory = "topicListenerzyh")
    public void readActiveQueue1(String message, TextMessage textMessage) {
        System.out.println("topic接受到：zyh" + message);
    } //topic模式的消费者

    @JmsListener(destination = MqConstant.DOG, containerFactory = "topicListenerdog")
    public void readActiveQueue2(String message, TextMessage textMessage) {
        System.out.println("topic接受到：dog" + message);
    } //topic模式的消费者

    @JmsListener(destination = MqConstant.CAT, containerFactory = "topicListenercat")
    public void readActiveQueue3(String message, TextMessage textMessage) {
        System.out.println("topic接受到：cat" + message);
    }
}