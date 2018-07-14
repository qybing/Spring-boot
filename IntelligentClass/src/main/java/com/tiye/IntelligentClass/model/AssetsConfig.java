package com.tiye.IntelligentClass.model;

import java.io.Serializable;
import java.util.Date;


public class AssetsConfig implements Serializable {
    //id
    private  Long id;
    //资产ID由客户端生成。
    private String  assetsId;
    //学校id
    private String xxJbxxId;

    //年级Id
    private String xxNjxxId;

    //班级id
    private String xxBjxxId;
    //创建时间
    private String createTime;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAssetsId() {
        return assetsId;
    }

    public void setAssetsId(String assetsId) {
        this.assetsId = assetsId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getXxJbxxId() {
        return xxJbxxId;
    }

    public void setXxJbxxId(String xxJbxxId) {
        this.xxJbxxId = xxJbxxId;
    }

    public String getXxNjxxId() {
        return xxNjxxId;
    }

    public void setXxNjxxId(String xxNjxxId) {
        this.xxNjxxId = xxNjxxId;
    }

    public String getXxBjxxId() {
        return xxBjxxId;
    }

    public void setXxBjxxId(String xxBjxxId) {
        this.xxBjxxId = xxBjxxId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
