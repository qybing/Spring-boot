package com.tiye.IntelligentClass.pcController;

import com.tiye.IntelligentClass.common.APIResult;
import com.tiye.IntelligentClass.service.ClassCultureService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/pc/class")
@RestController
public class CultureController {
    private Logger log = Logger.getLogger(this.getClass());
    @Autowired
    @Qualifier("classCulture")
    private ClassCultureService classCultureService;

    @GetMapping("/slogan")
    public APIResult getSlogan(String xxBjxxId){
        try {
            log.info("获取班级口号");
            String slogan =classCultureService.getSlogans(xxBjxxId);
            Map<String,Object> map =new HashMap<>();
            map.put("slogan",slogan);
            return APIResult.result(0,"获取口号成功",0,map);
        }catch (Exception e){
            log.info("获取班级口号失败"+e.getCause());
            return APIResult.result(1,"获取口号失败",0,null);
        }
    }

}
