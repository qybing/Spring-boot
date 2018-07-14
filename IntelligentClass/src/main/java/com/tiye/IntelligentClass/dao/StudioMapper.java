package com.tiye.IntelligentClass.dao;

import com.tiye.IntelligentClass.model.Studio;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StudioMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Studio record);

    int insertSelective(Studio record);

    Studio selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Studio record);

    int updateByPrimaryKey(Studio record);

    //查看全部直播室
    List<Studio> selectAll();

    int deleteBatch(String[] ids);

    //查看全部直播室
    List<Studio> selectAllAndPage(Map<String,Object> params);


    //查询总条数
    int selectPageCount();
}