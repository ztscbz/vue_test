package com.zt.test.consumer;

import com.zt.config.RabbitMqAnnexConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * @author: ZT
 * @date: 2020/9/1 13:57
 */
@Component
@Slf4j
public class TopicAnnexReceiver {
    @RabbitListener(
            bindings =
                    {
                            @QueueBinding(value = @Queue(value = RabbitMqAnnexConfig.TOPIC_QUEUE_NAME, durable = "true"),
                                    exchange = @Exchange(value = RabbitMqAnnexConfig.ATLP_TOPIC_EXCHANGE, type = "topic"),
                                    key = RabbitMqAnnexConfig.TOPIC_ROUTINGKEY)
                    })
    @RabbitHandler
    public void processTopicMsg(Message message) {
        System.out.println(message);
        String msg = new String(message.getBody(), StandardCharsets.UTF_8);
        log.info("log : " + msg);
    }
}
