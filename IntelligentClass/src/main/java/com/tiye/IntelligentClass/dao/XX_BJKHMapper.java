package com.tiye.IntelligentClass.dao;

import com.tiye.IntelligentClass.model.XX_BJKH;
import com.tiye.IntelligentClass.model.XX_BJXX;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface XX_BJKHMapper {
    int deleteByPrimaryKey(Integer xxBjkhId);

    int insert(XX_BJKH record);

    int insertSelective(XX_BJKH record);

    XX_BJKH selectByPrimaryKey(Integer xxBjkhId);

    int updateByPrimaryKeySelective(XX_BJKH record);

    int updateByPrimaryKey(XX_BJKH record);

    //通过班级ID获取口号
    String selectKH(@Param("xxBjxxId") String xxBjxxId);


}