package com.shopsphere.productservice.controller;

import com.shopsphere.productservice.common.response.ApiResponse;
import com.shopsphere.productservice.common.util.ApiResponseUtil;
import com.shopsphere.productservice.config.CurrentUser;
import com.shopsphere.productservice.dto.request.CreateProductRequest;
import com.shopsphere.productservice.dto.request.UpdateProductRequest;
import com.shopsphere.productservice.dto.response.ProductResponse;
import com.shopsphere.productservice.enums.Role;
import com.shopsphere.productservice.security.RequireRole;
import com.shopsphere.productservice.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @RequireRole({
            Role.ADMIN,
            Role.SELLER
    })
    @PostMapping
    public ResponseEntity<ApiResponse<ProductResponse>> createProduct(CurrentUser currentUser,
                                                                      @Valid @RequestBody CreateProductRequest request) {

        ProductResponse response =
                productService.createProduct(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponseUtil.success(
                                "Product created successfully",
                                response
                        )
                );
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<ApiResponse<ProductResponse>> getProduct(
            @PathVariable UUID uuid) {

        ProductResponse response =
                productService.getProductByUuid(uuid);

        return ResponseEntity.ok(
                ApiResponseUtil.success(
                        "Product fetched successfully",
                        response
                )
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductResponse>>> getAllProducts() {

        List<ProductResponse> response =
                productService.getAllProducts();

        return ResponseEntity.ok(
                ApiResponseUtil.success(
                        "Products fetched successfully",
                        response
                )
        );
    }

    @RequireRole({
            Role.ADMIN,
            Role.SELLER
    })
    @PutMapping("/{uuid}")
    public ResponseEntity<ApiResponse<ProductResponse>> updateProduct(
            @PathVariable UUID uuid,
            @Valid @RequestBody UpdateProductRequest request) {

        ProductResponse response =
                productService.updateProduct(uuid, request);

        return ResponseEntity.ok(
                ApiResponseUtil.success(
                        "Product updated successfully",
                        response
                )
        );
    }

    @RequireRole({
            Role.ADMIN,
            Role.SELLER
    })
    @DeleteMapping("/{uuid}")
    public ResponseEntity<ApiResponse<Object>> deleteProduct(
            @PathVariable UUID uuid) {

        productService.deleteProduct(uuid);

        return ResponseEntity.ok(
                ApiResponseUtil.success(
                        "Product deleted successfully",
                        null
                )
        );
    }
}