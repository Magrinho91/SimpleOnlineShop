package com.example.SimpleOnlineShop.feature.user.controller;

import com.example.SimpleOnlineShop.feature.user.model.UserModel;
import com.example.SimpleOnlineShop.feature.user.dto.UserModelDto;
import com.example.SimpleOnlineShop.feature.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("getAll")
    public List<UserModel> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("registerUser")
    public void registerUser(@RequestBody final UserModelDto userModelDto) {
        userService.registerUser(userModelDto);
    }

    @GetMapping("loggedAccount")
    public UserModel getLoggedAccount() {
        return userService.getLoggedAccount();
    }
}
