package com.shopsphere.productservice.dto.response;

import com.shopsphere.productservice.enums.ProductStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    private UUID uuid;

    private String name;

    private String description;

    private BigDecimal price;

    private Integer quantity;

    private String brand;

    private UUID sellerId;

    private ProductStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}