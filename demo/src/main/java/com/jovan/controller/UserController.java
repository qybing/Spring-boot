package com.jovan.controller;

import com.jovan.bean.User;
import com.jovan.mapper.UserMapper;

import com.jovan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

    @Autowired
    UserService userService;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getUserInfo")
    public List<User> getUserInfo() {
        List<User> user = userMapper.findAllUser();
        return user;
    }

    @RequestMapping("/insert")
    public void insert(String name,String password,String phone) {
        User u = new User();
        int id = userMapper.insert1(name,password,phone);
    }


}

