package com.rxh.complat.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 *
 * @Description: ActiveMq配置
 * @Author Zhang YuHui
 * @Date 2020/11/18 11:09
 *
 */
//@Configuration
public class ActiviteMqConfig {

    /**
     * 提取配置文件参数信息
     *
     */
    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;

    @Value("${spring.activemq.user}")
    private String username;

    @Value("${spring.activemq.topic-name}")
    private String password;

    @Value("${spring.activemq.queue-name}")
    private String queueName;

    @Value("${spring.activemq.topic-name}")
    private String topicName;


    @Bean(name = "queue")
    public Queue queue() {
        return new ActiveMQQueue(queueName);
    }

    @Bean(name = "topic")
    public Topic topic() {
        return new ActiveMQTopic(topicName);
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(username, password, brokerUrl);
        return factory;
    }

    @Bean
    public JmsMessagingTemplate jmsMessageTemplate() {
        return new JmsMessagingTemplate(connectionFactory());
    }


    // 在Queue模式中，对消息的监听需要对containerFactory进行配置
    @Bean("queueListener")
    public JmsListenerContainerFactory<?> queueJmsListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        //是否启用发布订阅模式 true为发布订阅 false为点对点
        factory.setPubSubDomain(false);

        return factory;
    }

    //在Topic模式中，对消息的监听需要对containerFactory进行配置
    @Bean("topicListener")
    public JmsListenerContainerFactory<?> topicJmsListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();

        factory.setConnectionFactory(connectionFactory);
        //是否启用发布订阅模式 true为发布订阅 false为点对点
        factory.setPubSubDomain(true);
        return factory;
    }

    //订阅-发布持久化设置.
    @Bean("topicListenertest")
    public JmsListenerContainerFactory<?> topicJmsListenerContainerFactory1(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();

        factory.setConnectionFactory(connectionFactory);
        factory.setSubscriptionDurable(true);
        factory.setClientId("toptest");
        factory.setPubSubDomain(true);
        return factory;
    }

    @Bean("topicListenerzyh")
    public JmsListenerContainerFactory<?> topicJmsListenerContainerFactory3(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();

        factory.setConnectionFactory(connectionFactory);
        factory.setSubscriptionDurable(true);
        factory.setClientId("topzyh");
        factory.setPubSubDomain(true);
        return factory;
    }

    @Bean("topicListenerdog")
    public JmsListenerContainerFactory<?> topicJmsListenerContainerFactory2(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();

        factory.setConnectionFactory(connectionFactory);
        factory.setSubscriptionDurable(true);
        factory.setClientId("topdog");
        factory.setPubSubDomain(true);
        return factory;
    }
    @Bean("topicListenercat")
    public JmsListenerContainerFactory<?> topicJmsListenerContainerFactory0(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();

        factory.setConnectionFactory(connectionFactory);
        factory.setSubscriptionDurable(true);
        factory.setClientId("topcat");
        factory.setPubSubDomain(true);
        return factory;
    }

}
