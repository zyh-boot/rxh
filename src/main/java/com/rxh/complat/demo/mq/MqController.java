package com.rxh.complat.demo.mq;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 *
 * @Description: Mq测试客户端连接
 * @Author Zhang YuHui 
 * @Date 2020/11/18 17:25
 *
 */
@RestController
public class MqController {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    @PostMapping("/queue/test")
    public String sendQueue(String str) {

        for (int i = 0; i < 10; i++) {
            this.sendMessage(queue, "queue:" + i);
        }

        return "success";
    }

    @PostMapping("/topic/test")
    public String sendTopic(String str) {
        this.sendMessage(new ActiveMQTopic("com.test"), "test持久化测试");
        return "success";
    }

    @PostMapping("/topic/zyh")
    public String sendTopic1(String str) {
        this.sendMessage(new ActiveMQTopic("com.zyh"), "zyh持久化测试");
        return "success";
    }

    @PostMapping("/topic/dog")
    public String sendTopic2(String str) {
        this.sendMessage(new ActiveMQTopic("com.dog"), "dog持久化测试");
        return "success";
    }

    @PostMapping("/topic/cat")
    public String sendTopic3(String str) {
        this.sendMessage(new ActiveMQTopic("com.cat"), "cat持久化测试");
        return "success";
    }

    // 发送消息，destination是发送到的队列，message是待发送的消息
    private void sendMessage(Destination destination, final String message) {
        jmsMessagingTemplate.convertAndSend(destination, message);
    }
}
