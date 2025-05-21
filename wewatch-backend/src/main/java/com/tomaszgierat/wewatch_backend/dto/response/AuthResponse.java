package com.tomaszgierat.wewatch_backend.dto.response;

import com.tomaszgierat.wewatch_backend.model.ROLE;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponse {
    private String token;
    private Long userId;
    private String nickname;
    private ROLE role;
}
