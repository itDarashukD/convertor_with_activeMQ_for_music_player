package com.darashuk.activeMQ.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Queue;

@Configuration
public class ActiveMqConfig {

    @Value("${activemq.broker-url}")
    private String brokerUrl;

    @Bean
    public Queue createQueue() {
        return new ActiveMQQueue("Standalone.queue");
    }

    @Bean
    public ActiveMQConnectionFactory createConnectionFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL(brokerUrl);
        return factory;
    }

    @Bean
    public JmsTemplate createJmsTemplate() {
        return new JmsTemplate(createConnectionFactory());
    }
}