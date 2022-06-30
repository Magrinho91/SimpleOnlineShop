package com.example.SimpleOnlineShop.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("getAll")
    public List<UserModel> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("registerUser")
    public void registerUser(@RequestBody final UserModelDto userModelDto) {
        userService.registerUser(userModelDto);
    }
}
