package com.tomaszgierat.wewatch_backend.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tomaszgierat.wewatch_backend.dto.request.RegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testRegisterEndpoint_Valid() throws Exception{
        RegisterRequest registerRequest = new RegisterRequest("Test", "User","TestAccount","test@example.com", "test123");

        mockMvc.perform(post("/api/auth/register")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(registerRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token", notNullValue()));
    }

    @Test
    public void testRegisterEndpoint_MissingFields_BadRequest() throws Exception {
        RegisterRequest invalidRequest = new RegisterRequest();

        mockMvc.perform(post("/api/auth/register")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString((invalidRequest))))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void testRegisterEndpoint_DuplicateEmail_UnprocessableEntity() throws Exception{
        RegisterRequest registerRequest = new RegisterRequest("Duplicate", "Email","DuplicateEmail","duplicate@example.com", "test123");

        mockMvc.perform(post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(registerRequest)))
                .andExpect(status().isOk());

        mockMvc.perform(post("/api/auth/register")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(registerRequest)))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void testRegisterEndpoint_NotFound_WrongPath() throws Exception{
        RegisterRequest registerRequest = new RegisterRequest("Wrong", "Path","WrongPath","wrongpath@gmail.com", "test123");

        mockMvc.perform(post("/api/auth/WrongPath")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(registerRequest)))
                .andExpect(status().isNotFound());
    }
}
