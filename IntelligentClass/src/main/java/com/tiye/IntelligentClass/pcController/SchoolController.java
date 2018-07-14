package com.tiye.IntelligentClass.pcController;


import com.tiye.IntelligentClass.common.APIResult;
import com.tiye.IntelligentClass.model.XX_BJXX;
import com.tiye.IntelligentClass.model.XX_JBXX;
import com.tiye.IntelligentClass.model.XX_NJXX;
import com.tiye.IntelligentClass.service.SchoolService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pc")
public class SchoolController {
    private Logger log = Logger.getLogger(this.getClass());
    @Autowired
    @Qualifier("schoolService")
    SchoolService schoolService;

    @GetMapping("/school")
    public APIResult ScoolList() {
        log.info("获取学校列表");
        try {
            List<XX_JBXX> xxJbxxWithBLOBs = schoolService.allSchool();
            return APIResult.result(0, "获取学校列表成功", xxJbxxWithBLOBs.size(), xxJbxxWithBLOBs);

        } catch (Exception e) {
            log.info("获取学校列表失败" + e.getCause());
            return APIResult.result(1, "获取学校列表失败", 0, null);
        }
    }


    @GetMapping("/grade")
    public APIResult ScoolGrade(String xxJbxxId) {
        log.info("获取当前学校的全部年级");
        try {
            List<XX_NJXX> xx_njxx = schoolService.selectNJ(xxJbxxId);
            return APIResult.result(0, "获取当前学校的全部年级成功", xx_njxx.size(), xx_njxx);
        } catch (Exception e) {
            log.info("获取当前学校的全部年级失败" + e.getCause());
            return APIResult.result(1, "获取当前学校的全部年级失败", 0, null);
        }
    }


    @GetMapping("/class")
    public APIResult ScoolClass(String xxJbxxId, String xxNjxxId) {
        log.info("获取班级列表");
        try {
            List<XX_BJXX> xx_bjxxes  = schoolService.selectBJ(xxJbxxId, xxNjxxId);
            return APIResult.result(0, "获取班级列表成功", xx_bjxxes.size(), xx_bjxxes);
        } catch (Exception e) {
            log.info("获取班级列表失败" + e.getCause());
            e.printStackTrace();
            return APIResult.result(1, "获取班级列表失败", 0, null);
        }
    }


    @GetMapping("/allclass")
    public APIResult ScoolAllClass(String xxJbxxId) {
        log.info("获取班级列表");
        try {
            List<XX_BJXX> xx_bjxxes  = schoolService.selectABJ(xxJbxxId);
            return APIResult.result(0, "获取班级列表成功", xx_bjxxes.size(), xx_bjxxes);
        } catch (Exception e) {
            log.info("获取班级列表失败" + e.getCause());
            e.printStackTrace();
            return APIResult.result(1, "获取班级列表失败", 0, null);
        }
    }



}
