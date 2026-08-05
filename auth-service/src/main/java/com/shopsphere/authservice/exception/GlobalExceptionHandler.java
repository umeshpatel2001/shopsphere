package com.shopsphere.authservice.exception;

import com.shopsphere.authservice.common.response.ApiResponse;
import com.shopsphere.authservice.common.util.ApiResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ApiResponse<Object>> handleEmailAlreadyExists(
            EmailAlreadyExistsException ex){

        return ResponseEntity.badRequest()
                .body(
                        ApiResponseUtil.error(
                                ex.getMessage()
                        )
                );

    }

}
