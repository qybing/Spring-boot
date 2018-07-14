package com.tiye.IntelligentClass.service;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.tiye.IntelligentClass.common.APIResult;
import com.tiye.IntelligentClass.dao.EbNoticeMapper;
import com.tiye.IntelligentClass.model.EbNotice;
import com.tiye.IntelligentClass.model.SysAccount;
import com.tiye.IntelligentClass.util.DateUtil;
import com.tiye.IntelligentClass.util.ParameterMap;
import com.tiye.IntelligentClass.util.StringTools;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project:IntelligentClass
 * @PackageName:com.tiye.IntelligentClass.service
 * @Auther: 张颖
 * @Date: 2018年05月15日 13:22
 * @Description:
 */
@Service
public class EbNoticeService {
    private Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    private EbNoticeMapper dao;

    public int  getNoticeListCount(ParameterMap params){
        return dao.getNoticeListCount(params);
    }

    public List<EbNotice> getNoticeListData(ParameterMap params){
        params.setPageParams();//设置分页的参数
        List<EbNotice> list=dao.getNoticeListData(params);
        return list;
    }
    public APIResult saveOrUpdateNotice(EbNotice notice,SysAccount acount){
        List<EbNotice> checkTitle=dao.selectByTitle(notice);
        if(checkTitle!=null&&checkTitle.size()>0){
            return APIResult.result(3,"标题重复",0,null);
        }
        String overTime=DateUtil.getAfterDayDate(notice.getPublishTime(),notice.getLastDay());
        notice.setOverTime(overTime);
        if("2".equals(notice.getPubType())){//校通知
            notice.setXx(acount.getXx());
        }
        if(notice!=null&&notice.getId()!=null){
           return  updateNotice(notice);
        }
        return addNotice(notice);
    }
    public APIResult addNotice(EbNotice notice){
        notice.setDel(false);
        notice.setCreateTime(DateUtil.getTime());
        int count=dao.insert(notice);
        if(count>0){
            return APIResult.result(0,"保存新通知成功",0,null);
        }else{
            return APIResult.result(4,"保存新通知失败",0,null);
        }
    }

    public APIResult updateNotice(EbNotice notice){
        int count=dao.updateByPrimaryKeySelective(notice);
        if(count>0){
            return APIResult.result(0,"修改新通知成功",0,null);
        }else{
            return APIResult.result(4,"修改新通知失败",0,null);
        }
    }
    public APIResult falseDelNotice(Long noticeId){
        if(noticeId==null){
            return APIResult.result(2,"参数为空",0,null);
        }
        int count=dao.falseDelByKey(noticeId);
        if(count>0){
            return APIResult.result(0,"删除成功",0,null);
        }
        return  APIResult.result(3,"删除失败",0,null);
    }

    public APIResult falseDelNotices(String noticeIds){
        if(StringTools.isEmpty(noticeIds)){
            return APIResult.result(2,"参数为空",0,null);
        }
        Long[] idArr = StringTools.strArr2LongArr(noticeIds);
        dao.falseDelByKeys(idArr);
        return APIResult.result(0,"删除成功",0,null);
    }

    public APIResult getNoticeDetail(Long noticeId){
        if(noticeId==null){
            return APIResult.result(2,"参数为空",0,null);
        }
        EbNotice notice=dao.selectByPrimaryKey(noticeId);
        return APIResult.result(1,"获取通知详情",0,notice);
    }

    public List<EbNotice> getNoticePc(String njFlag){
        return dao.getPcNotices(njFlag);
    }


}
