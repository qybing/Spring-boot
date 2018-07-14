package com.tiye.IntelligentClass.controller;

import com.tiye.IntelligentClass.common.APIResult;
import com.tiye.IntelligentClass.common.Const;
import com.tiye.IntelligentClass.model.EbNotice;
import com.tiye.IntelligentClass.model.SysAccount;
import com.tiye.IntelligentClass.service.EbNoticeService;
import com.tiye.IntelligentClass.util.StringTools;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Project:IntelligentClass
 * @PackageName:com.tiye.IntelligentClass.controller
 * @Auther: 张颖
 * @Date: 2018年05月15日 13:34
 * @Description:
 */
@Controller

@RequestMapping("/back/notice")
public class EbNoticeController extends BaseController{
    private Logger log = Logger.getLogger(this.getClass());

    @Autowired
    private EbNoticeService service;
    @Autowired
    private Environment env;

    /**
     * 通知分页数据
     * @return
     */
    @RequestMapping(value = "/getNoticeList",method = RequestMethod.POST)
    @ResponseBody
    public Object getNoticeList(){
        try{
            int count=service.getNoticeListCount(this.getParameterMap());
            List<EbNotice> data=service.getNoticeListData(this.getParameterMap());
            return APIResult.result(0,"获取通知的分页数据",count,data);
        }catch(Exception e){
            e.getCause();
            return APIResult.result(1,"后台异常",0,null);
        }
    }

    /**
     * 新增或修改通知
     * @param file
     * @param notice
     * @return
     */
    @RequestMapping(value = "/addOrUpdateNotice",method = RequestMethod.POST)
    @ResponseBody
    public Object addOrUpdateNotice(@RequestParam(value = "fontCover",required = false) MultipartFile file, EbNotice notice){
        try {
            String newFileName="";
            if(file!=null){
                if (file.isEmpty()) {
                    if(notice.getId()==null){
                        return APIResult.result(2,"封面图为空",0,null);
                    }
                }
                log.info( env.getProperty("mypros.uploadPath"));
                String fileName = file.getOriginalFilename();// 获取文件名
                log.info("上传的文件名为：" + fileName);
                String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 获取文件的后缀名
                log.info("上传的后缀名为：" + suffixName);
                newFileName= UUID.randomUUID().toString()+suffixName;
                String filePath = env.getProperty("mypros.uploadPath"); // 文件上传后的路径
                File dest = new File(filePath + newFileName);
                if (!dest.getParentFile().exists()) { //检测是否存在目录
                    dest.getParentFile().mkdirs();
                }
                file.transferTo(dest);
            }else{
                if(notice.getId()==null){
                    return APIResult.result(2,"封面图为空",0,null);
                }
            }
            if(!StringTools.isEmpty(newFileName)){
                notice.setPicPath(env.getProperty("mypros.filePrefix")+"/"+newFileName);
            }
            SysAccount account=(SysAccount) this.getSession().getAttribute(Const.SESSION_USER);
            APIResult result=service.saveOrUpdateNotice(notice,account);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return APIResult.result(1,"后台异常",0,null);
        }

    }

    /**
     * 删除通知(逻辑删除)
     * @param noticeId
     * @return
     */
    @RequestMapping(value = "/delNotice",method = RequestMethod.GET)
    @ResponseBody
    public Object delNotice(Long noticeId){
        try{
           return  service.falseDelNotice(noticeId);
        }catch(Exception e){
            e.getCause();
            return APIResult.result(1,"后台异常",0,null);
        }
    }

    /**
     * 批量删除通知(逻辑删除)
     * @param noticeIds
     * @return
     */
    @RequestMapping(value = "/delNotices",method = RequestMethod.GET)
    @ResponseBody
    public Object delNotices(String noticeIds){
        try{
            return  service.falseDelNotices(noticeIds);
        }catch(Exception e){
            e.getCause();
            return APIResult.result(1,"后台异常",0,null);
        }
    }

    /**
     * 获取通知详情
     * @param noticeId
     * @return
     */
    @RequestMapping(value = "/getNoticeDetail",method = RequestMethod.GET)
    @ResponseBody
    public Object getNoticeDetail(Long noticeId){
        try{
            return  service.getNoticeDetail(noticeId);
        }catch(Exception e){
            e.getCause();
            return APIResult.result(1,"后台异常",0,null);
        }
    }



}
