package com.shopsphere.productservice.exception;

import com.shopsphere.productservice.common.response.ApiResponse;
import com.shopsphere.productservice.common.util.ApiResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleProductNotFound(
            ProductNotFoundException ex) {

        return ResponseEntity.badRequest()
                .body(
                        ApiResponseUtil.error(ex.getMessage())
                );

    }

}