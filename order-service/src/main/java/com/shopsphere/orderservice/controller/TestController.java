package com.shopsphere.orderservice.controller;

import com.shopsphere.orderservice.client.ProductClient;
import com.shopsphere.orderservice.client.dto.ApiResponse;
import com.shopsphere.orderservice.client.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final ProductClient productClient;

    @GetMapping("/{id}")
    public ApiResponse<ProductResponse> test(
            @PathVariable Long id) {

        return productClient.getProductById(id);
    }
    @GetMapping("/test/header")
    public String header(
            @RequestHeader("X-User-Email") String email) {

        return email;

    }
}