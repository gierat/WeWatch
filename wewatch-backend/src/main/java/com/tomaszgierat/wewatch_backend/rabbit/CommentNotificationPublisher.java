package com.tomaszgierat.wewatch_backend.rabbit;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentNotificationPublisher {

    private final RabbitTemplate rabbitTemplate;

    public void publish(CommentNotificationEvent event) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.COMMENT_QUEUE, event);
    }
}