package com.tomaszgierat.wewatch_backend.mapper;

import com.tomaszgierat.wewatch_backend.dto.response.CommentResponse;
import com.tomaszgierat.wewatch_backend.model.Comment;

public class CommentMapper {

    public static CommentResponse mapToResponse(Comment comment) {
        return CommentResponse.builder()
                .id(comment.getId())
                .nickname(comment.getUser().getNickname())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .build();
    }
}