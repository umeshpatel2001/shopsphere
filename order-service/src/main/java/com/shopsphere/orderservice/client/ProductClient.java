package com.shopsphere.orderservice.client;

import com.shopsphere.orderservice.client.dto.ApiResponse;
import com.shopsphere.orderservice.client.dto.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "product-service"
)
public interface ProductClient {

    @GetMapping("/internal/products/{id}")
    ApiResponse<ProductResponse> getProductById(
            @PathVariable Long id
    );
}