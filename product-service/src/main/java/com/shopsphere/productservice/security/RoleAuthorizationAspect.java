package com.shopsphere.productservice.security;

import com.shopsphere.productservice.config.CurrentUser;
import com.shopsphere.productservice.enums.Role;
import com.shopsphere.productservice.exception.AccessDeniedException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class RoleAuthorizationAspect {

    @Before("@annotation(requireRole)")
    public void authorize(
            JoinPoint joinPoint,
            RequireRole requireRole) {

        CurrentUser currentUser = null;

        for (Object arg : joinPoint.getArgs()) {

            if (arg instanceof CurrentUser user) {
                currentUser = user;
                break;
            }

        }

        if (currentUser == null) {
            throw new RuntimeException(
                    "CurrentUser not found");
        }

        Role currentRole =
                Role.valueOf(currentUser.getRole());

        boolean allowed =
                Arrays.asList(requireRole.value())
                        .contains(currentRole);

        if (!allowed) {

            throw new AccessDeniedException(
                    "You don't have permission to perform this action."
            );

        }

        log.info("Authorization Success");

    }

}