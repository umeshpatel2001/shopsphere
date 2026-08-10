package com.shopsphere.productservice.service;

import com.shopsphere.productservice.dto.request.CreateProductRequest;
import com.shopsphere.productservice.dto.request.UpdateProductRequest;
import com.shopsphere.productservice.dto.response.ProductResponse;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    ProductResponse createProduct(CreateProductRequest request);

    ProductResponse getProductByUuid(UUID uuid);

    List<ProductResponse> getAllProducts();

    ProductResponse updateProduct(UUID uuid, UpdateProductRequest request);

    void deleteProduct(UUID uuid);

    ProductResponse getProductById(UUID id);
}