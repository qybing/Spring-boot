package com.tiye.IntelligentClass.service;


import com.tiye.IntelligentClass.dao.XX_BJXXMapper;
import com.tiye.IntelligentClass.dao.XX_JBXXMapper;
import com.tiye.IntelligentClass.dao.XX_NJXXMapper;
import com.tiye.IntelligentClass.model.XX_BJXX;

import com.tiye.IntelligentClass.model.XX_JBXX;
import com.tiye.IntelligentClass.model.XX_NJXX;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("schoolService")
public class SchoolService {

    @Autowired
    private XX_JBXXMapper xxJbxxMapper;

    @Autowired
    private XX_NJXXMapper xxNjxxMapper;

    @Autowired
    private XX_BJXXMapper xxBjxxMapper;


    public List<XX_JBXX> allSchool() {
        return xxJbxxMapper.findAll();
    }

    public List<XX_NJXX> selectNJ(String xxJbxxId) {
        return xxNjxxMapper.selectByPrimaryKey(xxJbxxId);
    }

    public List<XX_BJXX> selectBJ(String xxJbxxId, String xxNjxxId) {
        return xxBjxxMapper.selectNjByXN(xxJbxxId, xxNjxxId);
    }

    public List<XX_BJXX> selectABJ(String xxJbxxId) {
        return xxBjxxMapper.selectByXxId(xxJbxxId);
    }

    public  List<XX_BJXX> selectBjByNj(String nj){
        return xxBjxxMapper.selectBjByNj(nj);
    }

}
