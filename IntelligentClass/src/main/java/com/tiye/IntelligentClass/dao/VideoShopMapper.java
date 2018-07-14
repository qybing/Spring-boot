package com.tiye.IntelligentClass.dao;

import com.tiye.IntelligentClass.model.VideoShop;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface VideoShopMapper {
    int insert(VideoShop videoShop);
    void updateDelFlg(String ids,int delFlg);
    VideoShop get(long id);
    int update(VideoShop videoShop);
    long selectCount(Map params);
    List<VideoShop> select(Map params);
    List<VideoShop> getCy(int index,int curPage,String njDm);
    long getCyCount(@Param("njDm") String njDm);
    long getTypeCount(String njDm,String vtype);
    List<VideoShop> getByType(int index,int curPage,String njDm,String vtype);
}
