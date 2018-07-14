package com.tiye.IntelligentClass.controller;





import com.tiye.IntelligentClass.common.APIResult;
import com.tiye.IntelligentClass.common.Const;
import com.tiye.IntelligentClass.service.SysAccountService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;




/**
 * 用户控制器
 */
@Controller
@RequestMapping("/back/user")
public class SysAccountController extends BaseController{
    private Logger log = Logger.getLogger(this.getClass());
    @Autowired
    private SysAccountService service;

    /**
     * 登录
     * @return
     */
    @RequestMapping(value={"/login"},method= RequestMethod.GET)
    @ResponseBody
    public Object login(){
        log.info("登录开始");
        try{
            return service.userlogin(this.getParameterMap(), this.getSession());
        }catch (Exception e){
            log.info("登录失败:"+e.getCause());
            return APIResult.result(1, "登录失败,后台异常", 0, null);
        }
    }

    /**
     * 登出
     * @return
     */
    @RequestMapping(value={"/loginOut"},method= RequestMethod.GET)
    @ResponseBody
    public Object loginOut(){
        log.info("退出开始");
        try{
            this.getSession().removeAttribute(Const.SESSION_USER);
            return APIResult.result(0, "退出成功", 0, null);
        }catch (Exception e){
            log.info("登出失败:"+e.getCause());
            return APIResult.result(1, "退出失败,后台异常", 0, null);
        }
    }

    /**
     *用户没有登录，返回99
     * @return
     */
    @RequestMapping(value={"/noLogin"},method= RequestMethod.GET)
    @ResponseBody
    public Object noLogin(){
        return APIResult.result(99, "没有登录", 0, null);
    }

    /**
     * 测试使用，正式课删掉，先保留
     * @return
     */
    @RequestMapping(value={"/hi"},method= RequestMethod.GET)
    @ResponseBody
    public String hi(){
        return "hihi";
    }
}
