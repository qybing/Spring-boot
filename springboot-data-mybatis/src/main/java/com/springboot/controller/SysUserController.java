package com.springboot.controller;/*
 *
 *------------吴亦凡大魔王最帅-------------------/
 *         ┌─┐            ┌─┐
 *     ┌─┘─┴──────┘─┴─┐
 *     │                            │
 *     │             ─             │
 *     │    ┬─┘        └─┬    │
 *     │                            │
 *     │             ┴             │
 *     │                            │
 *     └───┐            ┌───┘
 *             │            │
 *             │            │
 *             │            └──────┐
 *             │                          ├┐
 *             │                          ┌┘
 *             └┐  ┐  ┌───┬─┐  ┌┘
 *               │  ┤  ┤      │  ┤  ┤
 *               └─┴─┘      └─┴─┘
 *─────────神兽出没──────────/
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.bean.SysUser;
import com.springboot.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/sysuser")
public class SysUserController {
    @Autowired
    private SysUserMapper sysUserMapper;

    @ResponseBody
    @GetMapping("/{account}")
    public SysUser getUserByAccount(@PathVariable("account") String account){
        return sysUserMapper.getSysUserByAccount(account);
    }

    @ResponseBody
    @GetMapping("/users")
    public PageInfo getSysUsers(@RequestParam(value = "pageNum",required = false, defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize",required = false, defaultValue = "10") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(sysUserMapper.getSysUsers(new HashMap<>()));
        return pageInfo;
    }

    @GetMapping("/user")
    public String userPage (){
        return "user";
    }

}
