package com.jovan.service.impl;

import com.jovan.bean.User;
import com.jovan.mapper.UserMapper;
import com.jovan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public User findUserByPhone(String phone) {
        return null;
    }

    @Override
    public int insert(String name, String password, String phone) {
        return 0;
    }

    @Override
    public int update(String name, Integer id) {
        return 0;
    }

    @Override
    public int Delete(Integer id) {
        return 0;
    }
}
