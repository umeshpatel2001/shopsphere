package com.shopsphere.authservice.mapper;

import com.shopsphere.authservice.dto.request.RegisterRequest;
import com.shopsphere.authservice.dto.response.RegisterResponse;
import com.shopsphere.authservice.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(RegisterRequest request);

    RegisterResponse toResponse(User user);

}
