package com.shopsphere.orderservice.dto.response;

import com.shopsphere.orderservice.enums.OrderStatus;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class OrderResponse {

    private UUID orderId;

    private UUID customerId;

    private BigDecimal totalAmount;

    private OrderStatus status;

    private List<OrderItemResponse> items;

    private LocalDateTime createdAt;
}