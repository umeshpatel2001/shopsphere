package com.shopsphere.productservice.service.impl;

import com.shopsphere.productservice.dto.request.CreateProductRequest;
import com.shopsphere.productservice.dto.request.UpdateProductRequest;
import com.shopsphere.productservice.dto.response.ProductResponse;
import com.shopsphere.productservice.entity.Product;
import com.shopsphere.productservice.exception.ProductNotFoundException;
import com.shopsphere.productservice.mapper.ProductMapper;
import com.shopsphere.productservice.repository.ProductRepository;
import com.shopsphere.productservice.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    @Override
    public ProductResponse createProduct(
            CreateProductRequest request) {

        Product product =
                productMapper.toEntity(request);

        Product savedProduct =
                productRepository.save(product);

        return productMapper.toResponse(savedProduct);

    }

    @Override
    public ProductResponse getProductByUuid(UUID uuid) {

        Product product =
                productRepository.findByUuid(uuid)
                        .orElseThrow(() ->
                                new ProductNotFoundException(
                                        "Product not found"));

        return productMapper.toResponse(product);

    }

    @Override
    public List<ProductResponse> getAllProducts() {

        return productRepository.findAll()

                .stream()

                .map(productMapper::toResponse)

                .toList();

    }

    @Override
    public ProductResponse updateProduct(
            UUID uuid,
            UpdateProductRequest request) {

        Product product =
                productRepository.findByUuid(uuid)
                        .orElseThrow(() ->
                                new ProductNotFoundException(
                                        "Product not found"));

        productMapper.updateProductFromRequest(
                request,
                product
        );

        Product updatedProduct =
                productRepository.save(product);

        return productMapper.toResponse(updatedProduct);

    }

    @Override
    public void deleteProduct(UUID uuid) {

        Product product =
                productRepository.findByUuid(uuid)
                        .orElseThrow(() ->
                                new ProductNotFoundException(
                                        "Product not found"));

        productRepository.delete(product);

    }

    @Override
    public ProductResponse getProductById(UUID id) {

        Product product = productRepository.findByUuid(id)
                .orElseThrow(() ->
                        new ProductNotFoundException("Product not found"));

        return productMapper.toResponse(product);
    }
}