package com.shopsphere.orderservice.controller;

import com.shopsphere.orderservice.client.ProductClient;
import com.shopsphere.orderservice.client.dto.ApiResponse;
import com.shopsphere.orderservice.client.dto.ProductResponse;
import com.shopsphere.orderservice.config.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/orders/test")
@RequiredArgsConstructor
public class TestController {

    private final ProductClient productClient;

    @GetMapping("/{id}")
    public ApiResponse<ProductResponse> test(
            @PathVariable Long id) {

        return productClient.getProductById(id);
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