package com.tomaszgierat.wewatch_backend.controller;


import com.tomaszgierat.wewatch_backend.config.JwtService;
import com.tomaszgierat.wewatch_backend.dto.request.AuthRequest;
import com.tomaszgierat.wewatch_backend.dto.request.RegisterRequest;
import com.tomaszgierat.wewatch_backend.dto.response.AuthResponse;
import com.tomaszgierat.wewatch_backend.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authenticationService;
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authenticationService.login(request));
    }

    @GetMapping("/validate")
    public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String authHeader) {
        String token = jwtService.getToken(authHeader);
        return authenticationService.validateToken(token);
    }

}