package com.tiye.IntelligentClass.service;


import com.tiye.IntelligentClass.common.APIResult;
import com.tiye.IntelligentClass.common.Const;
import com.tiye.IntelligentClass.dao.SysAccountMapper;
import com.tiye.IntelligentClass.model.SysAccount;
import com.tiye.IntelligentClass.util.ParameterMap;
import com.tiye.IntelligentClass.util.StringTools;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Project:smart-teach
 * @PackageName:com.tiye.smart.teach.manage.service
 * @Auther: 张颖
 * @Date: 2018年05月11日 15:33
 * @Description:
 */
@Service
public class SysAccountService {
    private Logger log = Logger.getLogger(this.getClass());
    @Autowired
    private SysAccountMapper dao;

    public APIResult userlogin(ParameterMap pm, HttpSession session) {
        String loginName = pm.getString("loginName");
        String password = pm.getString("password");
        log.info("登录用户名：" + loginName);
        log.info("登录密码：" + password);
        if (StringTools.isEmpty(loginName) || StringTools.isEmpty(password)) {
            log.info("参数错误：" + password);
            return APIResult.result(2, "参数错误", 0, null);
        }
        SysAccount account=dao.selectByNameAndPass(loginName,password);
        if (account==null){
            return APIResult.result(3, "用户名或密码错误",0, null);
        }
        session.setAttribute(Const.SESSION_USER,account);
        return APIResult.result(0, "登录成功",0, null);
    }

}
