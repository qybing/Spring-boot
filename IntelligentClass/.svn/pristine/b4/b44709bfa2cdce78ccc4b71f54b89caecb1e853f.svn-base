package com.tiye.IntelligentClass.dao;

import com.tiye.IntelligentClass.model.AssetsConfig;
import com.tiye.IntelligentClass.model.AssetsConfigEx;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetsConfigMapper {
    int insert(AssetsConfig assetsConfig);
    AssetsConfig getbyAssetsid(String assetsId);
    void update(AssetsConfig assetsConfig);
    AssetsConfigEx getXNB(@Param("assetsId") String assetsId);
}
