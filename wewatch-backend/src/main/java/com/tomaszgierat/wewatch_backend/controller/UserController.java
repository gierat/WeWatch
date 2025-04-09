package com.tomaszgierat.wewatch_backend.controller;

import com.tomaszgierat.wewatch_backend.dto.response.UserResponse;
import com.tomaszgierat.wewatch_backend.mapper.UserMapper;
import com.tomaszgierat.wewatch_backend.model.User;
import com.tomaszgierat.wewatch_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        var user = userRepository.findById(id);
        if (user.isPresent()) {
            User u = user.get();
            return ResponseEntity.ok(UserMapper.mapToResponse(user.get()));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
   }

}
