package com.jovan.mapper;

import com.jovan.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Mapper
//public interface UserMapper {
//
//    @Select("SELECT * FROM T_USER ")
//    List<User> findAllUser();
//
//    @Select("SELECT * FROM T_USER WHERE PHONE = #{phone}")
//    User findUserByPhone(@Param("phone") String phone);
//
//    @Insert("INSERT INTO T_USER(NAME, PASSWORD, PHONE) VALUES(#{name}, #{password}, #{phone})")
//    int insert(@Param("name") String name, @Param("password") String password, @Param("phone") String phone);
//
//    @Update("UPDATE T_USER SET NAME = #{name} WHERE ID = #{id}")
//    int update(@Param("name") String name, @Param("id") Integer id);
//
//    @Delete("DELETE FROM T_USER where id=#{id}")
//    int Delete(@Param("id") Integer id);
//}


@Mapper
public interface UserMapper {


    List<User> findAllUser();


    User findUserByPhone(String phone);


    int insert(User user);
    int insert1(@Param("name") String name,@Param("password") String password,@Param("phone") String phone);

    int update(@Param("id") Integer id,@Param("name") String name);

    int Delete(Integer id);
}