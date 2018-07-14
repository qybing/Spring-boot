package com.tiye.IntelligentClass.service;

import com.tiye.IntelligentClass.dao.AssetsConfigMapper;
import com.tiye.IntelligentClass.model.AssetsConfig;
import com.tiye.IntelligentClass.model.AssetsConfigEx;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AssetsConfigService {
    @Resource
    AssetsConfigMapper assetsConfigMapper;
    public void bind(AssetsConfig assetsConfig)
    {
        AssetsConfig oldConfig= assetsConfigMapper.getbyAssetsid(assetsConfig.getAssetsId());
        if(oldConfig==null)
        {
            assetsConfigMapper.insert(assetsConfig);
        }
        else {
            assetsConfig.setId(oldConfig.getId());
            assetsConfigMapper.update(assetsConfig);
        }
    }


    public AssetsConfigEx getXNB(String assetsId)
    {
        return assetsConfigMapper.getXNB(assetsId);
    }
}
