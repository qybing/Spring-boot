package com.tiye.IntelligentClass.dao;

import com.tiye.IntelligentClass.model.XX_NJXX;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface XX_NJXXMapper {
    public XX_NJXX getById(String xxNjxxId);

    int deleteByPrimaryKey(String xxNjxxId);

    int insert(XX_NJXX record);

    int insertSelective(XX_NJXX record);
    //通过学校ID获取当前学校的全部年级
    List<XX_NJXX> selectByPrimaryKey(String xxJbxxId);

    int updateByPrimaryKeySelective(XX_NJXX record);

    int updateByPrimaryKeyWithBLOBs(XX_NJXX record);

    int updateByPrimaryKey(XX_NJXX record);
}
