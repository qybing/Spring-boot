package com.tiye.IntelligentClass.controller;

import com.tiye.IntelligentClass.common.APIResult;
import com.tiye.IntelligentClass.common.ResultCode;
import com.tiye.IntelligentClass.model.VideoShop;
import com.tiye.IntelligentClass.pcController.AssetsConfigController;
import com.tiye.IntelligentClass.service.UpfileService;
import com.tiye.IntelligentClass.service.VideoShopService;
import com.tiye.IntelligentClass.util.ParameterMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("back/videoShop")
public class VideoShopController extends  BaseController{
    private static final Logger log= LoggerFactory.getLogger(VideoShopController.class);
    @Resource
    private VideoShopService videoShopService;

    @Resource
    UpfileService upfileService;

    @RequestMapping("/addOrUpdate")
    public APIResult addOrUpdate(MultipartFile file,VideoShop videoShop)
    {
        APIResult apiResult=new APIResult();
        try {
            if(file==null||file.isEmpty()) {
                if(videoShop.getId()==null)
                {
                    return APIResult.result(2, "封面图为空", 0, null);
                }
            }
            else {
                videoShop.setFrontCover(upfileService.upFile(file));
            }
            if(videoShop.getId()==null)
            {
                videoShopService.add(videoShop);
                apiResult.setMsg("添加成功");
            }
            else {
                videoShopService.update(videoShop);
                apiResult.setMsg("更新成功");
            }

        }
        catch (Exception e)
        {
            log.error(e.getMessage(),e);
            apiResult.setCode(ResultCode.ExceptionCode);
            apiResult.setMsg("操作失败");
        }
        return  apiResult;
    }

    @RequestMapping("/get")
    public APIResult get(long id)
    {
        APIResult apiResult=new APIResult();
        try {
            VideoShop videoShop= videoShopService.get(id);
            apiResult.setMsg("获取成功");
            apiResult.setData(videoShop);
        }
        catch (Exception e)
        {
            log.error(e.getMessage(),e);
            apiResult.setCode(ResultCode.ExceptionCode);
            apiResult.setMsg("获取失败");
        }
        return  apiResult;
    }

    @RequestMapping("/delete")
    public  APIResult delete(String ids)
    {
        APIResult apiResult=new APIResult();
        try {
             videoShopService.delete(ids);
            apiResult.setMsg("删除成功");
        }
        catch (Exception e)
        {
            log.error(e.getMessage(),e);
            apiResult.setCode(ResultCode.ExceptionCode);
            apiResult.setMsg("删除失败");
        }
        return  apiResult;
    }
    @RequestMapping("select")
    public APIResult select()
    {
        APIResult apiResult=new APIResult();
        try {
            ParameterMap parameterMap=this.getParameterMap();
            apiResult.setCount(videoShopService.selectCount(parameterMap));
            apiResult.setData(videoShopService.select(parameterMap));
            apiResult.setMsg("查询成功");
        }catch (Exception e)
        {
            log.error(e.getMessage(),e);
            apiResult.setCode(ResultCode.ExceptionCode);
            apiResult.setMsg("查询失败");
        }
        return apiResult;
    }
}
