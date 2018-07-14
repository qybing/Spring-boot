package com.tiye.IntelligentClass.dao;


import com.tiye.IntelligentClass.model.XX_BJXX;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface XX_BJXXMapper {
    int deleteByPrimaryKey(String xxBjxxId);

//    通过学校和年级返回班级列表
    List<XX_BJXX> selectNjByXN(@Param("xxJbxxId") String xxJbxxId, @Param("xxNjxxId") String xxNjxxId);

    int insert(XX_BJXX record);

    int insertSelective(XX_BJXX record);

    //通过学校ID获取当前学校的全部年级
    XX_BJXX selectByPrimaryKey(String xxBjxxId);

    int updateByPrimaryKeySelective(XX_BJXX record);

    int updateByPrimaryKeyWithBLOBs(XX_BJXX record);

    int updateByPrimaryKey(XX_BJXX record);

    //通过学校ID获取所有的班级信息
    List<XX_BJXX>  selectByXxId(@Param("xxJbxxId") String xxJbxxId);

    List<XX_BJXX> selectBjByNj(@Param("nj") String nj);

}