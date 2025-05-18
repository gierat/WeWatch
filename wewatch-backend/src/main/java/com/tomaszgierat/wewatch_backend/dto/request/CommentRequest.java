package com.tomaszgierat.wewatch_backend.dto.request;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequest {
    private Long movieId;
    private String content;
}