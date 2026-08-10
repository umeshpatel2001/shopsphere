package com.shopsphere.productservice.controller;

import com.shopsphere.productservice.common.response.ApiResponse;
import com.shopsphere.productservice.common.util.ApiResponseUtil;
import com.shopsphere.productservice.dto.response.ProductResponse;
import com.shopsphere.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/internal/products")
@RequiredArgsConstructor
public class InternalProductController {

    private final ProductService productService;

    @GetMapping("/{uuid}")
    public ApiResponse<ProductResponse> getProduct(
            @PathVariable UUID uuid) {

        return ApiResponseUtil.success(
                "Product fetched successfully",
                productService.getProductById(uuid)
        );
    }
}