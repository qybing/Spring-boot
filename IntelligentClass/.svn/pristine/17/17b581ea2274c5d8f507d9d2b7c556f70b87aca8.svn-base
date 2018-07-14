package com.tiye.IntelligentClass.service;

import com.tiye.IntelligentClass.common.APIResult;
import com.tiye.IntelligentClass.common.Const;
import com.tiye.IntelligentClass.dao.HandPaperMapper;
import com.tiye.IntelligentClass.model.HandPaper;
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
 * @Date: 2018年05月21日 09:20
 * @Description:
 */
@Service
public class HandPaperService {
    @Autowired
    private HandPaperMapper dao;

    public void setXXNjbjParams(ParameterMap params,HttpSession session){
        SysAccount account=(SysAccount)session.getAttribute(Const.SESSION_USER);
        params.put("xxJbxxId",account.getXx());
        params.put("xxNjxxId",account.getNj());
        params.put("xxBjxxId",account.getBj());

    }
    public APIResult getHandPaperList(ParameterMap params,HttpSession session){
        setXXNjbjParams(params,session);
        int count= dao.getHandPaperCount(params);
        params.setPageParams();
        List<HandPaper> data=dao.getHandPaperList(params);
        return APIResult.result(0,"获取成功",count,data);
    }

    public APIResult getHandPapersPc(ParameterMap params){
        int count= dao.getHandPaperCount(params);
        params.setPageParams();
        List<HandPaper> data=dao.getHandPaperList(params);
        return APIResult.result(0,"获取成功",count,data);
    }
    public APIResult addOrUpHandPaper(HandPaper paper, HttpSession session){
        SysAccount account=(SysAccount)session.getAttribute(Const.SESSION_USER);
        String xx=account.getXx();
        String nj=account.getNj();
        String bj=account.getBj();
        paper.setXx(xx);
        paper.setNj(nj);
        paper.setBj(bj);
        if(paper.getId()!=null){
            return upHandPaper(paper);
        }
        return addHandPaper(paper);
    }
    public APIResult addHandPaper(HandPaper paper){
        paper.setCreateTime(DateUtil.getTime());
        paper.setDel(false);
        int count=dao.insert(paper);
        if(count>0){
            return APIResult.result(0,"新增成功",0,null);
        }else{
            return APIResult.result(2,"新增失败",0,null);
        }
    }

    public APIResult upHandPaper(HandPaper paper){
        int count=dao.updateByPrimaryKeySelective(paper);
        if(count>0){
            return APIResult.result(0,"修改成功",0,null);
        }else{
            return APIResult.result(2,"修改失败",0,null);
        }
    }

    public APIResult getHandPaperDetail(Long id){
        if(id==null){
            return APIResult.result(2,"参数错误",0,null);
        }
        HandPaper paper=dao.selectByPrimaryKey(id);
        return APIResult.result(0,"获取成功",0,paper);
    }

    public APIResult falseDelById(Long id){
        if(id==null){
            return APIResult.result(2,"参数错误",0,null);
        }
        int count=dao.falseDelById(id);
        if(count>0){
            return APIResult.result(0,"删除成功",0,null);
        }
        return APIResult.result(3,"删除失败",0,null);
    }

    public APIResult falseDelByIds(String  ids){
        if(StringTools.isEmpty(ids)){
            return APIResult.result(2,"参数为空",0,null);
        }
        Long[] idArr = StringTools.strArr2LongArr(ids);
        dao.falseDelByIds(idArr);
        return APIResult.result(0,"删除成功",0,null);
    }

}
