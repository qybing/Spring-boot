package com.jovan;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jovan.model.Person;
import com.jovan.model.User;
import com.jovan.service.PersonService;
import com.jovan.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootUserConsumerApplicationTests {
    @Reference
    UserService userService;

    @Reference
    PersonService personService;

    @Test
    public void contextLoads() {
        List<User> users = userService.getAllUser();
        for (User user:users) {
            System.out.println(user.getName());
        }
    }

    @Test
    public void testPerson() {
        Object obj = personService.selectAll(1);
//        for (Person person:persons) {
//            System.out.println(person.getName());
//            System.out.println(person.getMobile());
//        }
    }
}
