package com.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.bean.User;
import com.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @ResponseBody
    @GetMapping("/user/{pageNum}/{pageSize}")
    public List<User> findUser(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<User> list =  userMapper.findUser();
//        PageInfo<User> pageInfo = new PageInfo<>(list);
        PageInfo pageInfo = new PageInfo(list);
        System.out.println("total: "+pageInfo.getTotal()+", pageNum: "+pageInfo.getPageNum()+", pageSize: "+pageInfo.getSize());
        return list;
    }

}
