package com.tiye.IntelligentClass.controller;

import com.tiye.IntelligentClass.common.APIResult;
import com.tiye.IntelligentClass.model.ClassHonor;
import com.tiye.IntelligentClass.service.ClassHonorService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Project:IntelligentClass
 * @PackageName:com.tiye.IntelligentClass.controller
 * @Auther: 张颖
 * @Date: 2018年05月18日 09:21
 * @Description:
 */
@Controller
@RequestMapping("/back/classHonor")
public class ClassHonorController extends BaseController{
    private Logger log = Logger.getLogger(this.getClass());
    @Autowired
    private ClassHonorService service;

    /**
     * 获取班级荣誉分页数据
     * @return
     */
    @RequestMapping(value = "/getHonorList",method = RequestMethod.POST)
    @ResponseBody
    public Object getHonorList(){
        try{
            int count=service.getHonorCount(this.getParameterMap(),this.getSession());
            List<ClassHonor> data=service.getHonorList(this.getParameterMap(),this.getSession());
            return APIResult.result(0,"获取班级荣誉成功",count,data);
        }catch(Exception e){
            e.getCause();
            return APIResult.result(1,"后台异常",0,null);
        }
    }

    /**
     * 新增或修改班级荣誉
     * @param honor
     * @return
     */
    @RequestMapping(value = "/addOrUpHonor",method = RequestMethod.POST)
    @ResponseBody
    public Object addOrUpHonor(ClassHonor honor){
        try{
            return service.saveOrUpHonor(honor,this.getSession());
        }catch (Exception e){
            e.getCause();
            return APIResult.result(1,"后台异常",0,null);
        }
    }

    /**
     * 获取班级荣誉详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/getHonorDetail",method = RequestMethod.GET)
    @ResponseBody
    public Object getHonorDetail(Long id){
        try{
            return service.getHonorDetail(id);
        }catch (Exception e){
            e.getCause();
            return APIResult.result(1,"后台异常",0,null);
        }
    }

    /**
     * 单个逻辑删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/falseDelById",method = RequestMethod.GET)
    @ResponseBody
    public Object falseDelById(Long id){
        try{
            return service.falseDelById(id);
        }catch (Exception e){
            e.getCause();
            return APIResult.result(1,"后台异常",0,null);
        }
    }

    /**
     * 批量逻辑删除
     * @param ids
     * @return
     */
    @RequestMapping(value = "/falseDelByIds",method = RequestMethod.GET)
    @ResponseBody
    public Object falseDelByIds(String ids){
        try{
            return service.falseDelByIds(ids);
        }catch (Exception e){
            e.getCause();
            return APIResult.result(1,"后台异常",0,null);
        }
    }

}
