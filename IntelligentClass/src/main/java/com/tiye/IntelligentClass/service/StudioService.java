package com.tiye.IntelligentClass.service;

import com.tiye.IntelligentClass.dao.StudioMapper;
import com.tiye.IntelligentClass.model.Studio;
import com.tiye.IntelligentClass.util.ParameterMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service("studio")
public class StudioService {

    @Autowired
    StudioMapper studioMapper;

    //添加直播室
    public int saveStudio(Studio studio) {
        return studioMapper.insertSelective(studio);
    }

    //查询所有直播室
    public List<Studio> getAllStudio() {
        return studioMapper.selectAll();
    }

    //通过直播室ID删除直播室
    public int deleteStudio(Integer id) {
        return studioMapper.deleteByPrimaryKey(id);
    }

    //通过ID修改直播室配置
    public int updateStudio(Studio studio) {
        return studioMapper.updateByPrimaryKeySelective(studio);
    }

    //通过ID修改直播室配置
    public int deleteBatch(String[] ids) {
        return studioMapper.deleteBatch(ids);
    }

    //分页查询直播室
    public List<Studio> getAllPageStudio(ParameterMap params, HttpSession session) {
        params.setPageParams();
        return studioMapper.selectAllAndPage(params);
    }

    //获取直播室的页数
    public int getAllStudioCount() {
        return studioMapper.selectPageCount();
    }
}
