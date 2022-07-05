package com.example.SimpleOnlineShop.user;


import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
public enum UserRole {

    CLIENT(UserRoleValues.User_CLIENT), SELLER(UserRoleValues.User_SELLER), ADMIN(UserRoleValues.User_ADMIN);

    public final String value;

    public static UserRole fromValue (final String value) {
        return Arrays.stream(UserRole.values())
                .filter(role -> role.value.equals(value))
                .findFirst().orElseThrow();
    }

    public interface UserRoleValues {
        String User_CLIENT = "CLIENT";
        String User_SELLER = "SELLER";
        String User_ADMIN = "ADMIN";
    }
}
