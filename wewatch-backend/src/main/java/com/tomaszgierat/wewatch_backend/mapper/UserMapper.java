package com.tomaszgierat.wewatch_backend.mapper;

import com.tomaszgierat.wewatch_backend.dto.response.UserResponse;
import com.tomaszgierat.wewatch_backend.model.User;

public class UserMapper {
    public static UserResponse mapToResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .nickname(user.getNickname())
                .role(user.getRole().name())
                .build();
    }
}