package com.tiye.IntelligentClass.pcController;

import com.tiye.IntelligentClass.common.APIResult;
import com.tiye.IntelligentClass.common.ResultCode;
import com.tiye.IntelligentClass.model.VideoShop;
import com.tiye.IntelligentClass.service.ScopUtilService;
import com.tiye.IntelligentClass.service.VideoShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/pc/videoShop")
public class PcVideoShopController {
    private static final Logger log= LoggerFactory.getLogger(AssetsConfigController.class);
    @Resource
    VideoShopService videoShopService;
    @Resource
    ScopUtilService scopUtilService;
    /**
     * 获取常用资源
     * @return
     */
    @RequestMapping("/getCy")
    public APIResult getCy(int pageSize,int curPage,String xxNjxxId)
    {
        APIResult apiResult=new APIResult();
        try {
            String njDm=scopUtilService.getNj(xxNjxxId);
            if(njDm==null)
            {
                apiResult.setCode(2);
                apiResult.setMsg("没有找到年级信息");
                return  apiResult;
            }
            long count=videoShopService.getCyCount(njDm);
            List<VideoShop> videoShops=videoShopService.getCy(pageSize,curPage,njDm);
            apiResult.setCount(count);
            apiResult.setData(videoShops);
            apiResult.setMsg("获取成功");
        }
        catch (Exception e)
        {
            log.error(e.getMessage(),e);
            apiResult.setCode(ResultCode.ExceptionCode);
            apiResult.setMsg("获取失败");
        }
        return  apiResult;
    }

    /**
     * 通过类型获取资源
     * @param pageSize
     * @param curPage
     * @param xxNjxxId
     * @param vtype
     * @return
     */
    @RequestMapping("/getByType")
    public APIResult getByType(int pageSize,int curPage,String xxNjxxId,String vtype)
    {
        APIResult apiResult=new APIResult();
        try {
            String njDm=scopUtilService.getNj(xxNjxxId);
            if(njDm==null)
            {
                apiResult.setCode(2);
                apiResult.setMsg("没有找到年级信息");
                return  apiResult;
            }
            long count=videoShopService.getTypeCount(njDm,vtype);
            List<VideoShop> videoShops=videoShopService.getByType(pageSize,curPage,njDm,vtype);
            apiResult.setCount(count);
            apiResult.setData(videoShops);
            apiResult.setMsg("获取成功");
        }
        catch (Exception e)
        {
            log.error(e.getMessage(),e);
            apiResult.setCode(ResultCode.ExceptionCode);
            apiResult.setMsg("获取失败");
        }
        return  apiResult;
    }
}
