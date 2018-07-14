package com.tiye.IntelligentClass.service;


import com.tiye.IntelligentClass.dao.XX_NJXXMapper;
import com.tiye.IntelligentClass.model.XX_NJXX;
import com.tiye.IntelligentClass.util.ParameterMap;
import com.tiye.IntelligentClass.util.StringTools;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;

/**
 * 判断学校，年级，班级范围的服务类
 */
@Service
public class ScopUtilService {
    private Logger logger = Logger.getLogger(this.getClass());
    @Resource
    XX_NJXXMapper xx_njxxMapper;


    /**
     * 通过年级ID获取该年级对应的x1--x6 c1-c3 g1-g3 的值
     * @param xxNjxxId
     * @return
     */
    public String getNj(String xxNjxxId)
    {
        XX_NJXX xx_njxx= xx_njxxMapper.getById(xxNjxxId);
        if(xx_njxx==null)
        {
            return null;
        }
        int rxnf= Integer.parseInt(xx_njxx.getRxnf());
        Calendar c=Calendar.getInstance();
        int curNf=c.get(Calendar.YEAR);
        int curMonth=c.get(Calendar.MONTH);
        //当前年级为当前年份和入学年份的差
        int curKNj=curNf-rxnf;
        //当前月份大于8为下学期
        if(curMonth>=7)
        {
            curKNj+=1;
        }
        String flg="";
        switch (xx_njxx.getJyjd())
        {
            case "1":
                flg="x";
                break;
            case "2":
                flg="c";
                break;
            case "3":
                flg="g";
                break;
             default:
                 break;
        }
        return  flg+curKNj;
    }

    public boolean checkPCParams(ParameterMap params){
        boolean checkP=true;
        String sb=params.getString("assetsId");//设备ID
        String xx=params.getString("xxJbxxId");//学校ID
        String nj=params.getString("xxNjxxId");//年级ID
        String bj=params.getString("xxBjxxId");//班级ID
        logger.info("设备ID："+sb+"学校ID："+xx+"年级ID："+nj+"班级ID："+bj);
        if(StringTools.isEmpty(sb)){
            checkP=false;
        }
        if(StringTools.isEmpty(xx)){
            checkP=false;
        }

        if(StringTools.isEmpty(nj)){
            checkP=false;
        }
        if(StringTools.isEmpty(bj)){
            checkP=false;
        }
        return checkP;
    }
}
