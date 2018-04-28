package com.jovan.service.impl;

import com.jovan.bean.User;
import com.jovan.mapper.UserMapper;
import com.jovan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int saveUser(String acc, String pwd) {
        int flag = userMapper.insert(acc,pwd);
        return flag;

    }

    @Override
    public User selectUser(String acc) {
        User user = userMapper.selectUserByAcc(acc);
        return user;
    }
}
