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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authenticationService;
    private final JwtService jwtService;

    @Operation(summary = "Register a new user", description = "Registers a new user and returns a JWT token.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User registered successfully",
                    content = @Content(schema = @Schema(implementation = AuthResponse.class))),
            @ApiResponse(responseCode = "422", description = "Email already exists",
                    content = @Content)
    })
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @Operation(summary = "Login user", description = "Authenticates the user and returns a JWT token and user info.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User authenticated successfully",
                    content = @Content(schema = @Schema(implementation = AuthResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid credentials",
                    content = @Content)
    })
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authenticationService.login(request));
    }

    @Operation(summary = "Validate JWT token", description = "Checks whether the provided JWT token is valid and not expired.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Token is valid", content = @Content(schema = @Schema(example = "Token is valid"))),
            @ApiResponse(responseCode = "401", description = "Invalid or expired token", content = @Content(schema = @Schema(example = "Invalid token")))
    })
    @GetMapping("/validate")
    public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String authHeader) {
        String token = jwtService.getToken(authHeader);
        return authenticationService.validateToken(token);
    }

}