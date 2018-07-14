package com.tiye.IntelligentClass.dao;

import com.tiye.IntelligentClass.model.SysAccount;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface SysAccountMapper {

    SysAccount selectByNameAndPass(@Param("loginName")String loginName,@Param("password")String password);


}