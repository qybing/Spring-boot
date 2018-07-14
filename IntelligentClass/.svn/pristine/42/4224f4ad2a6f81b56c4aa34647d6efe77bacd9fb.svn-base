package com.tiye.IntelligentClass.pcController;

import com.tiye.IntelligentClass.common.APIResult;
import com.tiye.IntelligentClass.controller.BaseController;
import com.tiye.IntelligentClass.model.ClassHonor;
import com.tiye.IntelligentClass.service.ClassHonorService;
import com.tiye.IntelligentClass.service.ScopUtilService;
import com.tiye.IntelligentClass.util.ParameterMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Project:IntelligentClass
 * @PackageName:com.tiye.IntelligentClass.pcController
 * @Auther: 张颖
 * @Date: 2018年05月18日 13:33
 * @Description:
 */
@RequestMapping("/pc/honor")
@Controller
public class HonorController extends BaseController{
    private Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    private ClassHonorService service;
    @Autowired
    private ScopUtilService scopUtilService;

    /**
     * 客户端获取班级荣誉
     * @return
     */
    @RequestMapping("/getHonors")
    @ResponseBody
    public Object getHonors(){
        logger.info("客户端获取班级荣誉开始");
        try{
            ParameterMap params=this.getParameterMap();//参数
            if(!scopUtilService.checkPCParams(params)){
                return APIResult.result(2,"参数错误",0,null);
            }
            logger.info("客户端获取班级荣誉结束");
            List<ClassHonor> honors = service.getHonorsPc(params);
            return APIResult.result(0,"获取班级荣誉",0,honors);
        }catch (Exception e){
            logger.info("客户端获取班级荣誉异常");
            e.getCause();
            return APIResult.result(1,"后台异常",0,null);
        }

    }
}
