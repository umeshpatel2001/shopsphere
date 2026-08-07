package com.shopsphere.orderservice.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class OrderItemResponse {

    private Long productId;

    private Integer quantity;

    private BigDecimal price;

    private BigDecimal subtotal;
}