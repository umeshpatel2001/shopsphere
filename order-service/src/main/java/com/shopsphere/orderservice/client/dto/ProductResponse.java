package com.shopsphere.orderservice.client.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ProductResponse {

    private UUID uuid;

    private String name;

    private String description;

    private BigDecimal price;

    private Integer quantity;

    private String brand;

    private UUID sellerId;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}