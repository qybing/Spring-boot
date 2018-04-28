package com.jovan.test;

import com.jovan.bean.User;
import com.jovan.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest

public class SpringbootMybatisDemo2ApplicationTests {


    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1(){
        userMapper.insert("lisi","123456");
    }

    @Test
    public void test2(){
        User user = userMapper.selectUserByAcc("qwe123");
        if(user!=null) {
            System.out.println(user.getAcc());
            System.out.println(user.getPwd());
        }
        else {
            System.out.println("没有查到用户");
        }
    }



}
