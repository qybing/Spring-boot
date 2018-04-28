package com.jovan.mapper;


import com.jovan.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface UserMapper {
    //用户注册
    @Insert("insert into user(acc,pwd) values(#{acc},#{pwd})")
    int insert(@Param("acc") String acc, @Param("pwd") String pwd);

    //用户检测
    @Select("select * from user where acc=#{acc}")
    User selectUserByAcc(String acc);
}
