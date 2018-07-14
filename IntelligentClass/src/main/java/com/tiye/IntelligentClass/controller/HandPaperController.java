package com.tiye.IntelligentClass.controller;

import com.tiye.IntelligentClass.common.APIResult;
import com.tiye.IntelligentClass.model.HandPaper;
import com.tiye.IntelligentClass.service.HandPaperService;
import com.tiye.IntelligentClass.util.StringTools;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * @Project:IntelligentClass
 * @PackageName:com.tiye.IntelligentClass.controller
 * @Auther: 张颖
 * @Date: 2018年05月21日 09:21
 * @Description:
 */
@RequestMapping("/back/handPaper")
@Controller
public class HandPaperController extends BaseController{
    private Logger log = Logger.getLogger(this.getClass());
    @Autowired
    private HandPaperService service;
    @Autowired
    private Environment env;

    /**
     * 获取分页数据
     * @return
     */
    @RequestMapping("/getHandPaperList")
    @ResponseBody
    public Object getHandPaperList(){
        try{
            return service.getHandPaperList(this.getParameterMap(),this.getSession());
        }catch (Exception e){
            e.getCause();
            return APIResult.resultHtException();
        }
    }

    /**
     * 新增获取修改手抄报
     * @param pic
     * @param paper
     * @return
     */
    @RequestMapping(value = "/addOrUpHandPaper",method = RequestMethod.POST)
    @ResponseBody
    public Object addOrUpHandPaper(@RequestParam(value = "pic",required = false) MultipartFile pic,
                                   HandPaper paper){
        try{
            String newFileName="";
            if(pic!=null) {
                if (pic.isEmpty()) {
                    if (paper.getId() == null) {
                        return APIResult.result(2, "图片为空", 0, null);
                    }
                }
                log.info(env.getProperty("mypros.uploadPath"));
                String fileName = pic.getOriginalFilename();// 获取文件名
                log.info("上传的文件名为：" + fileName);
                String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 获取文件的后缀名
                log.info("上传的后缀名为：" + suffixName);
                newFileName = UUID.randomUUID().toString() + suffixName;
                String filePath = env.getProperty("mypros.uploadPath"); // 文件上传后的路径
                File dest = new File(filePath + newFileName);
                if (!dest.getParentFile().exists()) { //检测是否存在目录
                    dest.getParentFile().mkdirs();
                }
                pic.transferTo(dest);
            }else{
                    if(paper.getId()==null){
                        return APIResult.result(2,"图片为空",0,null);
                    }
            }
            if(!StringTools.isEmpty(newFileName)){
                paper.setPicPath(env.getProperty("mypros.filePrefix")+"/"+newFileName);
            }
            return service.addOrUpHandPaper(paper,this.getSession());
        }catch (Exception e){
            e.getCause();
            return APIResult.resultHtException();
        }
    }

    /**
     * 获取详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/getDetail",method = RequestMethod.GET)
    @ResponseBody
    public Object getDetail(Long id){
        try{
           return  service.getHandPaperDetail(id);
        }catch(Exception e){
            e.getCause();
            return APIResult.resultHtException();
        }
    }

    /**
     * 删除手抄报
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
            return APIResult.resultHtException();
        }
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping(value = "/falseDelByIds",method = RequestMethod.GET)
    @ResponseBody
    public Object falseDelById(String ids){
        try{
            return service.falseDelByIds(ids);
        }catch(Exception e){
            e.getCause();
            return APIResult.resultHtException();
        }
    }
}
