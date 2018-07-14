package com.tiye.IntelligentClass.controller;

import com.tiye.IntelligentClass.common.APIResult;
import com.tiye.IntelligentClass.model.InspectionNotice;
import com.tiye.IntelligentClass.service.InspectionNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Project:IntelligentClass
 * @PackageName:com.tiye.IntelligentClass.controller
 * @Auther: 张颖
 * @Date: 2018年05月17日 09:19
 * @Description:
 */
@Controller
@RequestMapping("/back/insNotice")
public class InspectionNoticeController extends BaseController{
    @Autowired
    private InspectionNoticeService service;

    /**
     * 获取分页数据
     * @return
     */
    @RequestMapping(value = "/getInsNoticeList",method = RequestMethod.POST)
    @ResponseBody
    public Object getInsNoticeList(){
        try{
            return service.getInsNoticeList(this.getParameterMap(),this.getSession());
        }catch (Exception e){
            e.getCause();
            return APIResult.result(0,"后台异常",0,null);
        }
    }
    /**
     * 新增或修改班级通告
     * @param notice
     * @return
     */
    @RequestMapping(value = "/saveOrUpNotice",method = RequestMethod.POST)
    @ResponseBody
    public Object saveOrUpNotice(InspectionNotice notice){
        try{
            return service.saveOrUpInsNotice(notice, this.getSession());
        }catch (Exception e ){
            e.getCause();
            return APIResult.result(1,"后台异常",0,null);
        }
    }

    /**
     * 逻辑删除班级通告
     * @param id
     * @return
     */
    @RequestMapping(value = "/falseDelById",method = RequestMethod.GET)
    @ResponseBody
    public Object falseDelById(Long id){
        try {
            return service.falseDelNotice(id);
        }catch (Exception e){
            e.getCause();
            return APIResult.result(1,"后台异常",0,null);
        }
    }
    /**
     * 逻辑删除班级通告
     * @param ids
     * @return
     */
    @RequestMapping(value = "/falseDelByIds",method = RequestMethod.GET)
    @ResponseBody
    public Object falseDelByIds(String  ids){
        try {
            return service.falseDelNotices(ids);
        }catch (Exception e){
            e.getCause();
            return APIResult.result(1,"后台异常",0,null);
        }
    }

    /**
     * 获取班级通告详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/getInsNoticeDetail",method = RequestMethod.GET)
    @ResponseBody
    public Object getInsNoticeDetail(Long id){
        try{
            return service.getInsNoticeDetail(id);
        }catch (Exception e ){
            e.getCause();
            return APIResult.result(1,"后台异常",0,null);
        }
    }
}
