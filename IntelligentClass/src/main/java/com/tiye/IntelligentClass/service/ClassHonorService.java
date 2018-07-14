package com.tiye.IntelligentClass.service;

import com.tiye.IntelligentClass.common.APIResult;
import com.tiye.IntelligentClass.common.Const;
import com.tiye.IntelligentClass.dao.ClassHonorMapper;
import com.tiye.IntelligentClass.model.ClassHonor;
import com.tiye.IntelligentClass.model.SysAccount;
import com.tiye.IntelligentClass.util.DateUtil;
import com.tiye.IntelligentClass.util.ParameterMap;
import com.tiye.IntelligentClass.util.StringTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @Project:IntelligentClass
 * @PackageName:com.tiye.IntelligentClass.service
 * @Auther: 张颖
 * @Date: 2018年05月18日 09:20
 * @Description:
 */
@Service
public class ClassHonorService {
    @Autowired
    private ClassHonorMapper dao;

    public void setPageListParams(ParameterMap params, HttpSession session){
        SysAccount account=(SysAccount)session.getAttribute(Const.SESSION_USER);
        params.put("xx",account.getXx());
        params.put("nj",account.getNj());
        params.put("bj",account.getBj());
    }
    public int getHonorCount(ParameterMap params, HttpSession session){
        setPageListParams(params,session);
        return dao.getHonorCount(params);
    }

    public List<ClassHonor> getHonorList(ParameterMap params, HttpSession session){
        setPageListParams(params,session);
        params.setPageParams();
        return dao.getHonorList(params);
    }
    public APIResult saveOrUpHonor(ClassHonor honor, HttpSession session){
        SysAccount account=(SysAccount) session.getAttribute(Const.SESSION_USER);
        honor.setXx(account.getXx());
        if(honor.getId()==null){
            return addClassHonor(honor);
        }
        return upClassHonor(honor);
    }
    public APIResult addClassHonor(ClassHonor honor){
        honor.setCreateTime(DateUtil.getTime());
        honor.setDel(false);
        int count=dao.insert(honor);
        if(count>0){
            return APIResult.result(0,"保存成功",0,null);
        }
        return APIResult.result(2,"保存失败",0,null);
    }

    public APIResult upClassHonor(ClassHonor honor){
        int count=dao.updateByPrimaryKeySelective(honor);
        if(count>0){
            return APIResult.result(0,"修改成功",0,null);
        }
        return APIResult.result(2,"修改失败",0,null);
    }

    public APIResult getHonorDetail(Long honorId){
        if(honorId==null){
            return APIResult.result(2,"参数错误",0,null);
        }
       ClassHonor honor = dao.selectByPrimaryKey(honorId);
       return APIResult.result(0,"获取班级荣誉详情",0,honor);
    }

    public APIResult falseDelById(Long id){
        if(id==null){
            return APIResult.result(2,"参数为空",0,null);
        }
        int count=dao.falseDesById(id);
        if(count>0){
            return APIResult.result(0,"删除成功",0,null);
        }
        return APIResult.result(3,"删除失败",0,null);
    }

    public APIResult falseDelByIds(String noticeIds){
        if(StringTools.isEmpty(noticeIds)){
            return APIResult.result(2,"参数为空",0,null);
        }
        Long[] idArr = StringTools.strArr2LongArr(noticeIds);
        dao.falseDelByIds(idArr);
        return APIResult.result(0,"删除成功",0,null);
    }

    public List<ClassHonor> getHonorsPc(ParameterMap map){
        return dao.getHonorPc(map);
    }

}
