package com.tiye.IntelligentClass.util;

/**
 * @Project:IntelligentClass
 * @PackageName:com.tiye.IntelligentClass.util
 * @Auther: 张颖
 * @Date: 2018年05月15日 08:53
 * @Description:
 */
public class StringTools {
    public static boolean isEmpty(String s) {
        return s == null || "".equals(s) || "null".equals(s);
    }

    public static Long[] strArr2LongArr(String s){
        String[] sArr=s.split(",");
        Long[] lArr=new Long[sArr.length];
        for (int i = 0; i < sArr.length; i++) {
            lArr[i] = Long.valueOf(sArr[i]);
        }
        return lArr;
    }
}
