package com.tomaszgierat.wewatch_backend.rabbit;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentNotificationEvent {
    private Long commentId;
    private Long movieId;
    private String movieTitle;
    private String nickname;
    private String content;
    private String createdAt;
}