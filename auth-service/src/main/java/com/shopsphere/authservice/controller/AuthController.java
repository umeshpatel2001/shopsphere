package com.shopsphere.authservice.controller;

import com.shopsphere.authservice.common.response.ApiResponse;
import com.shopsphere.authservice.common.util.ApiResponseUtil;
import com.shopsphere.authservice.dto.request.LoginRequest;
import com.shopsphere.authservice.dto.request.RegisterRequest;
import com.shopsphere.authservice.dto.response.LoginResponse;
import com.shopsphere.authservice.dto.response.RegisterResponse;
import com.shopsphere.authservice.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<RegisterResponse>> register(
            @Valid @RequestBody RegisterRequest request) {

        RegisterResponse response = authService.register(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponseUtil.success(
                                "User registered successfully",
                                response
                        )
                );
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> login(
            @Valid @RequestBody LoginRequest request) {

        LoginResponse response = authService.login(request);

        return ResponseEntity.ok(
                ApiResponseUtil.success(
                        "Login successful",
                        response
                )
        );
    }

    @GetMapping("/me")
    public ResponseEntity<String> me(Authentication authentication) {

        return ResponseEntity.ok(authentication.getName());

    }
}
