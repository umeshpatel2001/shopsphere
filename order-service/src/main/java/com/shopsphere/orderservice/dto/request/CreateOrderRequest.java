package com.shopsphere.orderservice.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class CreateOrderRequest {

    @NotNull(message = "Customer Id is required")
    private UUID customerId;

    @Valid
    @NotEmpty(message = "Order must contain at least one product")
    private List<OrderItemRequest> items;
}