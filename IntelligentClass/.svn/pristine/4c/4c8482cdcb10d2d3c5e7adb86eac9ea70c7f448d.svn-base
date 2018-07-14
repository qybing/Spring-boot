package com.tiye.IntelligentClass.dao;

import com.tiye.IntelligentClass.model.ClassHonor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ClassHonorMapper {

    int getHonorCount(Map<String,Object> params);

    List<ClassHonor> getHonorList(Map<String,Object> params);

    int insert(ClassHonor record);

    ClassHonor selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClassHonor record);

    int falseDesById(Long id);

    int falseDelByIds(Long[] ids);

    List<ClassHonor> getHonorPc(Map<String,Object> params);

}