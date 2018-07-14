package com.tiye.IntelligentClass.controller;


import com.tiye.IntelligentClass.common.APIResult;
import com.tiye.IntelligentClass.common.Const;
import com.tiye.IntelligentClass.model.SysAccount;
import com.tiye.IntelligentClass.service.ClassCultureService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/back/class")
public class ClassCultureController {
    private Logger log = Logger.getLogger(this.getClass());

    @Autowired
    @Qualifier("classCulture")
    ClassCultureService classCultureService;

    @GetMapping("/slogan")
    public APIResult classSlogan(HttpSession session) {
        log.info("获取班级口号");
        try {
            SysAccount user =  (SysAccount) session.getAttribute(Const.SESSION_USER);
            String slogan = classCultureService.getSlogans(user.getBj());
            return APIResult.result(0, "获取班级口号成功", 0, slogan);
        } catch (Exception e) {
            log.info("获取班级口号失败" + e.getCause());
            return APIResult.result(1, "获取班级口号失败", 0, null);
        }
    }

    @PutMapping("/slogan")
    public APIResult UpdataSlogan(HttpSession session,String slogan){
        log.info("修改班级口号");
        try {
            SysAccount user =  (SysAccount) session.getAttribute(Const.SESSION_USER);
            classCultureService.Update(user.getBj(),slogan);
            return APIResult.result(0, "修改班级口号成功", 0, null);
        }catch (Exception e){
            log.info("修改班级口号失败" + e.getCause());
            return APIResult.result(1, "修改班级口号失败", 0, null);
        }
    }
}
