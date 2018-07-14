package com.tiye.IntelligentClass.dao;

import com.tiye.IntelligentClass.model.EbNotice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EbNoticeMapper {

    List<EbNotice> selectByTitle(EbNotice record);
    int insert(EbNotice record);
    int falseDelByKey(Long id);

    int falseDelByKeys(Long[] ids);

    EbNotice selectByPrimaryKey(Long id);

    int getNoticeListCount(Map<String,Object> params);

    List<EbNotice> getNoticeListData(Map<String,Object> params);

    int updateByPrimaryKeySelective(EbNotice record);

    List<EbNotice> getPcNotices(@Param("xxNjxxId") String xxNjxxId);
}