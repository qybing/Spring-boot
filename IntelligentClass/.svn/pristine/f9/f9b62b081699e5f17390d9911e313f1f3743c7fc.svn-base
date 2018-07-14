package com.tiye.IntelligentClass.controller;

import com.tiye.IntelligentClass.common.APIResult;
import com.tiye.IntelligentClass.model.Studio;
import com.tiye.IntelligentClass.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/back/studio")
public class StudioController extends BaseController{

    private Logger log = Logger.getLogger(this.getClass());
    @Autowired
    @Qualifier("studio")
    private StudioService studioService;

    @PostMapping("/addStudio")
    public APIResult addStudio(Studio studio) {

        log.info("添加直播室");
        try {
            int result = studioService.saveStudio(studio);
            return APIResult.result(0, "添加直播室成功", 0, null);

        } catch (Exception e) {
            log.info("添加直播室失败:" + e.getCause());
            return APIResult.result(1,"后台异常",0,null);

        }
    }

    @GetMapping("/getAll")
    public APIResult getAll() {

        log.info("获取所有直播室");
        try {
            List<Studio> studioList = studioService.getAllStudio();
            if(studioList.size()>0){
                return APIResult.result(0,"获取所有直播室成功",studioList.size(),studioList);
            }else{
                return APIResult.result(0,"没有直播室的信息，需要添加",0,null);
            }

        } catch (Exception e) {
            log.info("获取所有直播室失败:" + e.getCause());
            return APIResult.resultHtException();

        }
    }

    @DeleteMapping("/delete")
    public APIResult deleteStudio(Integer id) {

        log.info("删除直播室");
        try {
            int result = studioService.deleteStudio(id);
            if (result == 1) {
                return APIResult.result(0, "删除直播室成功", 0, null);
            } else {
                return APIResult.result(1, "参数错误", 0, null);

            }

        } catch (Exception e) {
            log.info("删除直播室失败:" + e.getCause());
            return APIResult.resultHtException();

        }
    }

    @PutMapping("/update")
    public APIResult updateStudio(Studio studio) {

        log.info("修改直播室");
        try {
            int result = studioService.updateStudio(studio);
            if (result == 1) {
                return APIResult.result(0, "修改直播室成功", 0, null);
            } else {
                return APIResult.result(1, "参数错误", 0, null);

            }

        } catch (Exception e) {
            log.info("修改直播室失败:" + e.getCause());
            return APIResult.resultHtException();

        }
    }

    @DeleteMapping("/deleteBatch")
    public APIResult deleteManyStudio(@RequestParam("dates") String [] dates) {
        System.out.println(dates);
        log.info("批量删除直播室");
        try {
            int result = studioService.deleteBatch(dates);
            if (result == dates.length) {
                return APIResult.result(0, "批量删除直播室成功", 0, null);
            } else {
                return APIResult.result(1, "参数错误", 0, null);
            }

        } catch (Exception e) {
            log.info("批量删除直播室失败:" + e.getCause());
            return APIResult.resultHtException();

        }

    }

    @GetMapping("/getAllAndPage")
    public APIResult getAllAndPage() {
       /* int count = studioService.getAllStudioCount();
        System.out.println(count);*/
        log.info("获取所有直播室分页");
        try {
            int count = studioService.getAllStudioCount();
//            System.out.println(count);
            List<Studio> studioList = studioService.getAllPageStudio(this.getParameterMap(),this.getSession());
            if(studioList.size()>0){
                return APIResult.result(0,"获取所有直播室成功",count,studioList);
            }else{
                return APIResult.result(0,"没有直播室的信息，需要添加",0,null);
            }

        } catch (Exception e) {
            log.info("获取所有直播室失败:" + e.getCause());
            return APIResult.resultHtException();

        }
    }


}
