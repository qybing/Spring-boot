package com.jovan.test;

import com.jovan.bean.User;
import com.jovan.mapper.UserMapper;
import com.jovan.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.jovan.mapper")
public class SpringbootMybatisDemo2ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    //增
    @Test
    public void test1(){
        String name = "joe22";
        String password = "123456";
        String phone = "12345678910";
        User u = new User();
        u.setName(name);
        u.setPassword(password);
        u.setPhone(phone);
//        int result = userMapper.insert(u);
        int result1 = userMapper.insert1(name,password,phone);
        System.out.println(result1);
    }

    //按电话查讯
    @Test
    public void test2(){
        String phone = "12345678910";
        User u1 = userMapper.findUserByPhone(phone);
        System.out.println(u1.getName());
    }

    //改
    @Test
    public void test3(){
        User u = new User();
        String name = "jovan";
        Integer id = 1003;
        int result = userMapper.update(id,name);
        System.out.println(result);
    }

    //删
    @Test
    public void test4(){
        Integer id = 1000;
        int result = userMapper.Delete(id);
        System.out.println(result);
    }

    //查询所有
    @Test
    public void test5() {
        List<User> user = userMapper.findAllUser();

        for (User u : user) {
            System.out.println("名字为:" + u.getName() + "  密码为:" + u.getPassword() + "  电话:" + u.getPhone());
        }
//        List<User> user1= userMapper.findAllUser();
//        for(User u : user1){
//            System.out.println("名字为:"+u.getName()+"  密码为:"+u.getPassword()+"  电话:"+u.getPhone());
//        }
    }

}
