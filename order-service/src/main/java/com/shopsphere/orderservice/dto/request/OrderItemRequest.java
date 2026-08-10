package com.shopsphere.orderservice.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.UUID;

@Data
public class OrderItemRequest {

    @NotNull(message = "Product Id is required")
    private UUID productId;

    @Positive(message = "Quantity must be greater than zero")
    private Integer quantity;

}