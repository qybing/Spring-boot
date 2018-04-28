package com.jovan.controller;

import com.jovan.bean.User;
import com.jovan.service.UserService;
import com.jovan.utils.AppMD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("userService")
    UserService userService;

    @Autowired
    AppMD5Util appMD5Util;

    @GetMapping("/")
    public String index(){
        return "login";
    }

    @GetMapping("/getvar")
    @ResponseBody
    public String index1(@RequestParam("id") Integer id){
        System.out.println(id);
        return "id:"+id;
    }



    @PostMapping("/check")
    public String userRegister(String acc,String pwd,Model model){
//        AppMD5Util appMD5Util = new AppMD5Util();
        String pwd1 = appMD5Util.getMD5(pwd);

        System.out.println(acc);
        System.out.println(pwd1);
        int flag =userService.saveUser(acc,pwd1);
        if(flag==1){
//            model.addAttribute("messages","注册成功");
            return "login";
        }
        else {
            model.addAttribute("messages","注册失败");
            return "fail";
        }
    }

    @PostMapping("/login")
    public String userLogin(String acc,String pwd,Model model){
        User user = userService.selectUser(acc);

        if(user != null){
            String pwd1 = appMD5Util.getMD5(pwd);
            String pwd2 = user.getPwd();
//            System.out.println(pwd1);
//            System.out.println(pwd2);
            if(pwd1.equals(pwd2)){
                model.addAttribute("messages",user);
                return "success";
            }
            else{
                model.addAttribute("messages","密码错误");
                return "login";
            }
        }
        else{
            model.addAttribute("messages","没有该账号");
            return "login";
        }
    }
}
