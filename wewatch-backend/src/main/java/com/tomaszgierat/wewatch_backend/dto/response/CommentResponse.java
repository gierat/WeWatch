package com.tomaszgierat.wewatch_backend.dto.response;

import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentResponse {
    private Long id;
    private String nickname;
    private String content;
    private LocalDateTime createdAt;
}