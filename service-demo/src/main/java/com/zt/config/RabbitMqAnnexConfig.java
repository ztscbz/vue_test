package com.zt.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: RabbitMq 附件配置类
 * @author: ZT
 * @date: 2020/9/1 10:41
 */
@Configuration
public class RabbitMqAnnexConfig {

    public static final String TOPIC_QUEUE_NAME = "atlp_annex_topic_queue";
    public static final String ATLP_TOPIC_EXCHANGE = "atlpAnnexTopicExchange";
    public static final String TOPIC_ROUTINGKEY = "atlp.annex";

    //创建队列
    @Bean
    public Queue createLogTopicQueue() {
        return new Queue(TOPIC_QUEUE_NAME);
    }

    @Bean
    TopicExchange defLogTopicExchange(){
        return new TopicExchange(ATLP_TOPIC_EXCHANGE);
    }

    @Bean
    Binding bindingLogTopic() {
        return BindingBuilder.bind(createLogTopicQueue()).
                to(defLogTopicExchange()).
                with(TOPIC_ROUTINGKEY);
    }
}
