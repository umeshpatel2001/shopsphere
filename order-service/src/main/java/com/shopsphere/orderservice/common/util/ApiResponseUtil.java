package com.shopsphere.orderservice.common.util;

import com.shopsphere.orderservice.common.response.ApiResponse;

import java.time.LocalDateTime;

public class ApiResponseUtil {

    public static <T> ApiResponse<T> success(String message, T data) {

        return ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .timestamp(LocalDateTime.now())
                .build();

    }

    public static <T> ApiResponse<T> error(String message) {

        return ApiResponse.<T>builder()
                .success(false)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();

    }

}
