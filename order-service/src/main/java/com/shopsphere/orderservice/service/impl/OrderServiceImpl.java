package com.shopsphere.orderservice.service.impl;

import com.shopsphere.orderservice.config.CurrentUser;
import com.shopsphere.orderservice.dto.request.CreateOrderRequest;
import com.shopsphere.orderservice.dto.response.OrderResponse;
import com.shopsphere.orderservice.event.OrderCreatedEvent;
import com.shopsphere.orderservice.kafka.OrderProducer;
import com.shopsphere.orderservice.repository.OrderRepository;
import com.shopsphere.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderProducer orderProducer;

    @Override
    public OrderResponse createOrder(
            CurrentUser currentUser,
            CreateOrderRequest request) {

        // Save Order

        // Build OrderCreatedEvent

        // Publish Event
        // orderProducer.publish(event);

        // Return Response

        return null;
    }
}