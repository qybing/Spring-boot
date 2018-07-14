package com.tiye.IntelligentClass.pcController;

import com.tiye.IntelligentClass.common.APIResult;
import com.tiye.IntelligentClass.controller.BaseController;
import com.tiye.IntelligentClass.model.EbNotice;
import com.tiye.IntelligentClass.service.EbNoticeService;
import com.tiye.IntelligentClass.service.InspectionNoticeService;
import com.tiye.IntelligentClass.service.ScopUtilService;
import com.tiye.IntelligentClass.util.ParameterMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Project:IntelligentClass
 * @PackageName:com.tiye.IntelligentClass.pcController
 * @Auther: 张颖
 * @Date: 2018年05月17日 12:48
 * @Description:
 */
@Controller
@RequestMapping("/pc/notice")
public class NoticeController extends BaseController{
    private Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    private EbNoticeService noticeService;
    @Autowired
    private InspectionNoticeService insNoticeService;
    @Autowired
    private ScopUtilService scopUtilService;

    /**
     * PC客户端获取通知
     * @return
     */
    @RequestMapping(value = "/getNotices",method = RequestMethod.GET)
    @ResponseBody
    public Object getNotices(){
        logger.info("客户端获取通知开始");
        try{
            ParameterMap params=this.getParameterMap();//参数
            String nj=params.getString("xxNjxxId");//年级ID
            if(!scopUtilService.checkPCParams(params)){
                return APIResult.result(2,"参数错误",0,null);
            }
            String njFlag=scopUtilService.getNj(nj);
            List<EbNotice> notices = noticeService.getNoticePc(njFlag);
            logger.info("客户端获取通知结束");
            return APIResult.result(0,"pc获取通知成功",0,notices);
        }catch(Exception e){
            logger.info("客户端获取通知异常："+e.getCause());
            e.getCause();
            return APIResult.result(1,"后台异常",0,null);
        }
    }

    /**
     * 获取班级通告
     * @return
     */
    @RequestMapping(value = "/getInsNotices",method = RequestMethod.GET)
    @ResponseBody
    public Object getInsNotices(){
        logger.info("客户端获取班级通报开始");
        try{
            ParameterMap params=this.getParameterMap();//参数
            if(!scopUtilService.checkPCParams(params)){
                return APIResult.result(2,"参数错误",0,null);
            }
            logger.info("客户端获取班级通报结束");
            return insNoticeService.gteInsNoticesPc(params);
        }catch(Exception e){
            logger.info("客户端获取班级通报异常："+e.getCause());
            e.getCause();
            return APIResult.result(1,"后台异常",0,null);
        }
    }


}
