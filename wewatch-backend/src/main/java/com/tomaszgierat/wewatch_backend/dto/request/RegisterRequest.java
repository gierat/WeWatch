package com.tomaszgierat.wewatch_backend.dto.request;


import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstName;
    private String lastName;
    //private String username;
    private String email;
    private String password;


}
