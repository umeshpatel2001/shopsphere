package com.shopsphere.productservice.controller;

import com.shopsphere.productservice.common.response.ApiResponse;
import com.shopsphere.productservice.common.util.ApiResponseUtil;
import com.shopsphere.productservice.dto.response.ProductResponse;
import com.shopsphere.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/internal/products")
@RequiredArgsConstructor
public class InternalProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public ApiResponse<ProductResponse> getProduct(
            @PathVariable Long id) {

        return ApiResponseUtil.success(
                "Product fetched successfully",
                productService.getProductById(id)
        );
    }
}