package com.jovan.service;

import com.jovan.bean.User;

import java.util.List;

public interface UserService {

    List<User> findAllUser();


    User findUserByPhone(String phone);


    int insert(String name, String password,String phone);


    int update(String name,Integer id);

    int Delete(Integer id);
}
