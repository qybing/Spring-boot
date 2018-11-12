package com.jovan.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jovan.model.User;
import com.jovan.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Reference
    UserService userService;

    @GetMapping("/getUsers")
    public List<User> getAllUsers(){

        return userService.getAllUser();
    }
}
