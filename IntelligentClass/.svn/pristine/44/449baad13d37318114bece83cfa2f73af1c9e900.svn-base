package com.tiye.IntelligentClass.dao;

import com.tiye.IntelligentClass.model.InspectionNotice;
import com.tiye.IntelligentClass.util.ParameterMap;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface InspectionNoticeMapper {


    int insert(InspectionNotice record);

    InspectionNotice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(InspectionNotice record);

    int falseDelByKey(Long id);

    int falseDelByKeys(Long[] ids);

    int getInsNoticecount(Map<String,Object> params);

    List<InspectionNotice> getInsNoticeList(Map<String,Object> params);

    List<InspectionNotice> getInsNoticePc(ParameterMap params);
}