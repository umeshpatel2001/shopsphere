package com.shopsphere.orderservice.client.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {

    private boolean success;

    private String message;

    private T data;

    private LocalDateTime timestamp;
}