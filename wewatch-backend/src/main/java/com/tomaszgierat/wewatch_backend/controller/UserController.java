package com.tomaszgierat.wewatch_backend.controller;

import com.tomaszgierat.wewatch_backend.dto.response.UserResponse;
import com.tomaszgierat.wewatch_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    @Operation(
            summary = "Get user by ID",
            description = "Fetches a user's profile data by their unique ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found and returned successfully"),
            @ApiResponse(responseCode = "404", description = "User with the given ID was not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(
            @Parameter(description = "ID of the user to retrieve", example = "1")
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(userService.getUserById(id));
   }

}
