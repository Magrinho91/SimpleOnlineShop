package com.example.SimpleOnlineShop.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModelDto {

    private String role;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
}
