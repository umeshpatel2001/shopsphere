package com.shopsphere.productservice.mapper;

import com.shopsphere.productservice.dto.request.CreateProductRequest;
import com.shopsphere.productservice.dto.request.UpdateProductRequest;
import com.shopsphere.productservice.dto.response.ProductResponse;
import com.shopsphere.productservice.entity.Product;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toEntity(CreateProductRequest request);

    ProductResponse toResponse(Product product);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProductFromRequest(
            UpdateProductRequest request,
            @MappingTarget Product product
    );

}