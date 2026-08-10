package com.shopsphere.orderservice.controller;

import com.shopsphere.orderservice.client.ProductClient;
import com.shopsphere.orderservice.client.dto.ApiResponse;
import com.shopsphere.orderservice.client.dto.ProductResponse;
import com.shopsphere.orderservice.config.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders/test")
@RequiredArgsConstructor
public class TestController {

    private final ProductClient productClient;

    @GetMapping("/{uuid}")
    public ApiResponse<ProductResponse> test(
            @PathVariable UUID uuid) {

        return productClient.getProductById(uuid);
    }
    @GetMapping("/header")
    public String header(CurrentUser currentUser) {

        return """
            Email : %s
            UserId : %s
            Role : %s
            """.formatted(
                currentUser.getEmail(),
                currentUser.getUserId(),
                currentUser.getRole()
        );

    }
}