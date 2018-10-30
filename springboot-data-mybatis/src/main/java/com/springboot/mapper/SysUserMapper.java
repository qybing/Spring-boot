package com.springboot.mapper;

import com.springboot.bean.SysUser;

import java.util.List;
import java.util.Map;

public interface SysUserMapper {

    SysUser getSysUserByAccount(String account);

    List<SysUser> getSysUsers(Map<String,Object> map);
}
