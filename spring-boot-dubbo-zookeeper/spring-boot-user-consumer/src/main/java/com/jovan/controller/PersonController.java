package com.jovan.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jovan.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@RestController
@Controller
public class PersonController {

    @Reference
    PersonService personService;

    @ResponseBody
    @GetMapping("/getPerson/{pageNum}")
    public Object getAll(@PathVariable("pageNum") Integer pageNum){
        return personService.selectAll(pageNum);
    }

    @RequestMapping("/index")
    public String index(){
        return "main";
    }

    @ResponseBody
    @GetMapping("/delete/{id}")
    public Integer deleteByPrimaryKey(@PathVariable("id") String id){
        return personService.deleteByPrimaryKey(id);
    }
}
