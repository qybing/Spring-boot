package com.tiye.IntelligentClass.controller;

import com.tiye.IntelligentClass.common.APIResult;
import com.tiye.IntelligentClass.common.Const;
import com.tiye.IntelligentClass.model.SysAccount;
import com.tiye.IntelligentClass.model.SysMenu;
import com.tiye.IntelligentClass.service.SysMenuService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Project:IntelligentClass
 * @PackageName:com.tiye.IntelligentClass.controller
 * @Auther: 张颖
 * @Date: 2018年05月15日 11:08
 * @Description:
 */
@Controller
@RequestMapping("/back/menu")
public class SysMenuController extends BaseController{
    private Logger log = Logger.getLogger(this.getClass());
    @Autowired
    private SysMenuService menuService;

    /**
     * 用户获取权限菜单
     */
    @RequestMapping(value = "/getMenus",method = RequestMethod.GET)
    @ResponseBody
    public Object getMenus(){
        log.info("获取权限菜单");
        try{
            SysAccount account=(SysAccount) this.getSession().getAttribute(Const.SESSION_USER);
            List<SysMenu> menus=menuService.getMenus(account);
            return APIResult.result(0,"获取菜单成功",0,menus);
        }catch (Exception e){
            log.info("获取权限失败："+e.getCause());
            return APIResult.result(1,"获取菜单异常",0,null);
        }
    }
}
