package com.jovan.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jovan.model.User;
import com.jovan.service.UserService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Service
@Component
public class UserServiceImpl implements UserService {
    @Override
    public List<User> getAllUser() {
        User user1 = new User(1,"张三",20,"123456@qq.com");
        User user2 = new User(2,"李四",22,"1789@qq.com");
        return Arrays.asList(user1,user2);
    }
}
