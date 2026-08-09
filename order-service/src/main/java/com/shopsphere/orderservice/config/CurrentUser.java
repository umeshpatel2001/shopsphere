package com.shopsphere.orderservice.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CurrentUser {

    private final String email;

    private final String userId;

    private final String role;

}