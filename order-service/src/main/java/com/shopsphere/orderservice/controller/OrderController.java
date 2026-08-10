package com.shopsphere.orderservice.controller;

import com.shopsphere.orderservice.common.response.ApiResponse;
import com.shopsphere.orderservice.common.util.ApiResponseUtil;
import com.shopsphere.orderservice.config.CurrentUser;
import com.shopsphere.orderservice.dto.request.CreateOrderRequest;
import com.shopsphere.orderservice.dto.response.OrderResponse;
import com.shopsphere.orderservice.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<ApiResponse<OrderResponse>> createOrder(
            CurrentUser currentUser,
            @Valid @RequestBody CreateOrderRequest request) {

        OrderResponse response =
                orderService.createOrder(currentUser, request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        ApiResponseUtil.success(
                                "Order created successfully",
                                response
                        )
                );
    }
}