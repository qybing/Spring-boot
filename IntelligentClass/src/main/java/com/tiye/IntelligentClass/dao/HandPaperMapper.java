package com.tiye.IntelligentClass.dao;

import com.tiye.IntelligentClass.model.HandPaper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface HandPaperMapper {


    int insert(HandPaper record);

    HandPaper selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HandPaper record);

    int falseDelById(Long id);

    int falseDelByIds(Long[] ids);

    int getHandPaperCount(Map<String,Object> params);

    List<HandPaper> getHandPaperList(Map<String,Object> params);
}