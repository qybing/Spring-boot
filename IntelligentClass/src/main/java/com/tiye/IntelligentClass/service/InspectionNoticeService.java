package com.tiye.IntelligentClass.service;

import com.tiye.IntelligentClass.common.APIResult;
import com.tiye.IntelligentClass.common.Const;
import com.tiye.IntelligentClass.dao.InspectionNoticeMapper;
import com.tiye.IntelligentClass.model.InspectionNotice;
import com.tiye.IntelligentClass.model.SysAccount;
import com.tiye.IntelligentClass.util.DateUtil;
import com.tiye.IntelligentClass.util.ParameterMap;
import com.tiye.IntelligentClass.util.StringTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Project:IntelligentClass
 * @PackageName:com.tiye.IntelligentClass.service
 * @Auther: 张颖
 * @Date: 2018年05月17日 09:06
 * @Description:
 */
@Service
public class InspectionNoticeService {
    @Autowired
    private InspectionNoticeMapper dao;

    public void setAllParams(ParameterMap params,HttpSession session){
        SysAccount account=(SysAccount) session.getAttribute(Const.SESSION_USER);
        params.put("xx",account.getXx());
        params.put("nj",account.getNj());
        params.put("bj",account.getBj());
    }

    public APIResult getInsNoticeList(ParameterMap params,HttpSession session){
        setAllParams(params,session);
        int count=dao.getInsNoticecount(params);
        params.setPageParams();//设置分页参数
        List<InspectionNotice> data=dao.getInsNoticeList(params);
        return APIResult.result(0,"获取班级通报分页",count,data);
    }

    public APIResult saveOrUpInsNotice(InspectionNotice notice, HttpSession session){
        if(notice.getId()!=null){
            return upNotice(notice);
        }
        SysAccount account=(SysAccount) session.getAttribute(Const.SESSION_USER);
        return saveNotice(notice,account);
    }

    public APIResult saveNotice(InspectionNotice notice, SysAccount account){
        notice.setCreateTime(DateUtil.getTime());
        notice.setXx(account.getXx());
        notice.setDel(false);
        int count=dao.insert(notice);
        if(count>0){
            return APIResult.result(0,"保存成功",0,null);
        }
        return APIResult.result(2,"保存失败",0,null);
    }

    public APIResult upNotice(InspectionNotice notice){
        int count=dao.updateByPrimaryKeySelective(notice);
        if(count>0){
            return APIResult.result(0,"修改成功",0,null);
        }
        return APIResult.result(2,"修改失败",0,null);
    }

    public APIResult falseDelNotice(Long id){
        if(id==null){
            return APIResult.result(2,"参数为空",0,null);
        }
        int count=dao.falseDelByKey(id);
        if(count>0){
            return APIResult.result(0,"删除成功",0,null);
        }
        return APIResult.result(3,"删除失败",0,null);
    }
    public APIResult falseDelNotices(String noticeIds){
        if(StringTools.isEmpty(noticeIds)){
            return APIResult.result(2,"参数为空",0,null);
        }
        Long[] idArr = StringTools.strArr2LongArr(noticeIds);
        dao.falseDelByKeys(idArr);
        return APIResult.result(0,"删除成功",0,null);
    }

    public APIResult getInsNoticeDetail(Long id){
        if (id==null){
            return  APIResult.result(2,"参数为空",0,null);
        }
        InspectionNotice notice=dao.selectByPrimaryKey(id);
        return APIResult.result(0,"获取班级通告详情",0,notice);
    }

    public APIResult gteInsNoticesPc(ParameterMap params){
        return APIResult.result(0,"获取班级通告",0, dao.getInsNoticePc(params));
    }


}
