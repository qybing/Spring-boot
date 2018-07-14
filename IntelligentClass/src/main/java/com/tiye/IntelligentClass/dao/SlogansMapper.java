package com.tiye.IntelligentClass.dao;

import com.tiye.IntelligentClass.model.Slogans;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SlogansMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Slogans record);

    int insertSelective(Slogans record);
    //通过班级ID获取班级口号
    String selectByBj(String bj);

    //通过班级ID修改班级口号
    int updateSlogans(@Param("bj") String bj,@Param("slogans") String slogans);

    //通过班级ID增加口号
    int addSlogans(@Param("bj") String bj,@Param("slogans") String slogans);

    Slogans selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Slogans record);

    int updateByPrimaryKey(Slogans record);
}