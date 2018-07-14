package com.tiye.IntelligentClass.util;

public class PageUtil {
    public  static int getCurIndex(int pageSize,int curPage)
    {
        int index=pageSize*(curPage-1);
        if(index<0)
        {
            index=0;
        }
        return index;
    }
}
