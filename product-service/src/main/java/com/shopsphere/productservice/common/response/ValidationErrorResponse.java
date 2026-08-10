package com.shopsphere.productservice.common.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
public class ValidationErrorResponse {

    private boolean success;

    private String message;

    private Map<String, String> errors;

    private LocalDateTime timestamp;

}