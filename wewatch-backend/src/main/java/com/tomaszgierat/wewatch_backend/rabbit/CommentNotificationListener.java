package com.tomaszgierat.wewatch_backend.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CommentNotificationListener {

    @RabbitListener(queues = RabbitMQConfig.COMMENT_QUEUE)
    public void handleNewComment(CommentNotificationEvent event) {
        log.info("[RabbitMQ] New comment from {} on movie '{}': {}",
                event.getNickname(), event.getMovieTitle(), event.getContent());
    }
}
