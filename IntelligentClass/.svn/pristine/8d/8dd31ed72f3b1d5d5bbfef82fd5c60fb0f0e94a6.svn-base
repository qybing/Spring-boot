package com.tiye.IntelligentClass.pcController;

import com.tiye.IntelligentClass.common.APIResult;
import com.tiye.IntelligentClass.common.ResultCode;
import com.tiye.IntelligentClass.model.AssetsConfig;

import com.tiye.IntelligentClass.model.AssetsConfigEx;
import com.tiye.IntelligentClass.model.AssetsConfigMs;
import com.tiye.IntelligentClass.service.AssetsConfigService;
import com.tiye.IntelligentClass.service.ScopUtilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/pc/assetsConfig")
public class AssetsConfigController {

    private static final Logger log= LoggerFactory.getLogger(AssetsConfigController.class);

    @Resource
    AssetsConfigService assetsConfigService;

    /**
     * 绑定设备
     * @param assetsConfig
     * @return
     */
    @RequestMapping("/bind")
    public APIResult bind(AssetsConfig assetsConfig)
    {
        APIResult resout=new APIResult();
        try {
            assetsConfigService.bind(assetsConfig);
            resout.setMsg("绑定成功");
        }
        catch (Exception e)
        {
            log.error(e.getMessage(),e);
            resout.setCode(ResultCode.ExceptionCode);
            resout.setMsg("绑定失败");
        }

        return  resout;
    }


    @GetMapping("/getXNB")
    public APIResult getXNB(String assetsId)
    {
        log.info("获取学校年级班级");

        try {
            AssetsConfigEx assetsConfig =  assetsConfigService.getXNB(assetsId);
            if(assetsConfig==null){
                return APIResult.result(0,"没有绑定设备",0,null);
            }
            AssetsConfigMs assetsConfigMs = new AssetsConfigMs();
            assetsConfigMs.setXxmc(assetsConfig.getXxJbxx().getXxmc());
            assetsConfigMs.setXxJbxxId(assetsConfig.getXxJbxxId());
            assetsConfigMs.setNjmc(assetsConfig.getXxNjxx().getNjmc());
            assetsConfigMs.setXxNjxxId(assetsConfig.getXxNjxxId());
            assetsConfigMs.setBjmc(assetsConfig.getXxBjxx().getBjmc());
            assetsConfigMs.setXxBjxxId(assetsConfig.getXxBjxxId());
            assetsConfigMs.setBh(assetsConfig.getXxBjxx().getBh());
//            System.out.println(assetsConfig.getXxBjxx().getBjmc());
//            System.out.println(assetsConfig.getXxJbxx().getXxmc());
//            System.out.println(assetsConfig.getXxNjxx().getNjmc());
//            System.out.println(assetsConfig.getXxId());
//            System.out.println(assetsConfig.getNjId());
//            System.out.println(assetsConfig.getBjId());
//            System.out.println(assetsConfig);
            return APIResult.result(0,"获取学校年级班级成功",0,assetsConfigMs);
        }catch (Exception e){
            log.info("获取学校年级班级失败"+e.getCause());
            return APIResult.result(1,"获取学校年级班级失败",0,null);
        }
    }


    @Resource
    ScopUtilService scopUtilService;
    @RequestMapping("/test")
    public String test(String njId)
    {
        return scopUtilService.getNj(njId);
    }

}
