package com.example.SimpleOnlineShop.feature.user.role;


import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
public enum UserRole {

    CLIENT(UserRoleValues.ROLE_CLIENT), SELLER(UserRoleValues.ROLE_SELLER), ADMIN(UserRoleValues.ROLE_ADMIN);

    public final String value;

    public static UserRole fromValue (final String value) {
        return Arrays.stream(UserRole.values())
                .filter(role -> role.value.equals(value))
                .findFirst().orElseThrow();
    }

    public interface UserRoleValues {
        String ROLE_CLIENT = "ROLE_CLIENT";
        String ROLE_SELLER = "ROLE_SELLER";
        String ROLE_ADMIN = "ROLE_ADMIN";
    }
}
