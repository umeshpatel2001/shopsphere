package com.shopsphere.orderservice.service;

import com.shopsphere.orderservice.config.CurrentUser;
import com.shopsphere.orderservice.dto.request.CreateOrderRequest;
import com.shopsphere.orderservice.dto.response.OrderResponse;

public interface OrderService {

    OrderResponse createOrder(
            CurrentUser currentUser,
            CreateOrderRequest request
    );

}