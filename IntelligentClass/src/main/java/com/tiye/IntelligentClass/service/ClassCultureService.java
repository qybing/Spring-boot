package com.tiye.IntelligentClass.service;

import com.tiye.IntelligentClass.dao.SlogansMapper;
import com.tiye.IntelligentClass.dao.XX_BJKHMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("classCulture")
public class ClassCultureService {

    @Autowired
    private SlogansMapper slogansMapper;

    public String getSlogans(String bj){
        return slogansMapper.selectByBj(bj);
    }

    public int Update(String  bj,String slogan){
    int result = slogansMapper.updateSlogans(bj,slogan);
          return result;

    }
}
