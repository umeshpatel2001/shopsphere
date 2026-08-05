package com.shopsphere.authservice.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class RegisterResponse {

    private UUID uuid;

    private String firstName;

    private String lastName;

    private String email;

    private String message;
}
