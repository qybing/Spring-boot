package com.jovan.service;


import com.jovan.bean.User;
import org.springframework.stereotype.Service;


public interface UserService {

    int saveUser(String acc,String pwd);
    User selectUser(String acc);
}
