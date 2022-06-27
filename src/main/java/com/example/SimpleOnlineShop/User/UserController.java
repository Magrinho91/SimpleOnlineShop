package com.example.SimpleOnlineShop.User;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("getAll")
    public void getUsers(){
        userService.getUsers();
    }
}
