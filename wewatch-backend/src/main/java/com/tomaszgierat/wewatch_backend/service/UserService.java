package com.tomaszgierat.wewatch_backend.service;

import com.tomaszgierat.wewatch_backend.dto.response.UserResponse;
import com.tomaszgierat.wewatch_backend.mapper.UserMapper;
import com.tomaszgierat.wewatch_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse getUserById(Long id) {
        return userRepository.findById(id)
                .map(UserMapper::mapToResponse)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "User not found"));
    }
}