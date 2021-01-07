package com.rxh.complat.demo.mq;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 *
 * @Description: Mq测试客户端连接  消息生产者
 * @Author Zhang YuHui 
 * @Date 2020/11/18 17:25
 *
 */
//@RestController
public class MqController {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;


    @PostMapping("/queue/test")
    public String sendQueue(String str) {

        for (int i = 0; i < 10; i++) {
            //指定要发送到哪个消息队列中, 只有在这个队列的才能进行消费,这里传入的是通过配置文件来创建的消息队列.
            this.sendMessage(queue, "queue:" + i);
            //也可以自定义
            //this.sendMessage(new new ActiveMQQueue("queueName");, "自定义消息队列");
        }

        return "success";
    }

    @PostMapping("/topic/default")
    public String sendTopicDefault(String str) {
        //指定要发送到哪个主题中, 只有订阅了该主题的 才能接收到
        //通过自定义指向, 更加灵活.
        this.sendMessage(new ActiveMQTopic("com.default"), "default非持久化测试");
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
