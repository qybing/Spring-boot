package com.tiye.IntelligentClass.controller;

import com.tiye.IntelligentClass.common.APIResult;
import com.tiye.IntelligentClass.common.Const;
import com.tiye.IntelligentClass.model.SysAccount;
import com.tiye.IntelligentClass.model.XX_BJXX;
import com.tiye.IntelligentClass.model.XX_NJXX;
import com.tiye.IntelligentClass.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Project:IntelligentClass
 * @PackageName:com.tiye.IntelligentClass.controller
 * @Auther: 张颖
 * @Date: 2018年05月21日 10:04
 * @Description:
 */
@Controller
@RequestMapping("/back/XxNjbJ")
public class XxNjBjController extends BaseController{
    @Autowired
    private SchoolService schoolService;

    /**
     * 获取当前登录用户的所有年级
     * @return
     */
    @RequestMapping(value = "/getNjByXx",method = RequestMethod.GET)
    @ResponseBody
    private Object getNjByXx(){
        try{
            HttpSession session=this.getSession();
            SysAccount account=(SysAccount)session.getAttribute(Const.SESSION_USER);
            List<XX_NJXX> xx_njxx = schoolService.selectNJ(account.getXx());
            return APIResult.result(0, "获取当前学校的全部年级成功", xx_njxx.size(), xx_njxx);
        }catch (Exception e){
            return APIResult.resultHtException();
        }
    }


    /**
     * 获取当前登录用户的所有班级信息
     * @return
     */
    @RequestMapping(value = "/getBjByNj",method = RequestMethod.GET)
    @ResponseBody
    private Object getBjByNj(String nj){
        try {
            List<XX_BJXX> xx_bjxxes  = schoolService.selectBjByNj(nj);
            return APIResult.result(0, "获取班级列表成功", xx_bjxxes.size(), xx_bjxxes);
        } catch (Exception e) {
            e.printStackTrace();
            return APIResult.resultHtException();
        }
    }




}
