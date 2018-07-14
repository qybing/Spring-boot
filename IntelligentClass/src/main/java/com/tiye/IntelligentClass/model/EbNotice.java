package com.tiye.IntelligentClass.model;

/**
 * 教育局和学校的通知
 */
public class EbNotice {
    private Long id;//主键

    private String title;//标题

    private String subTitle;//副标题

    private String content;//内容

    private String picPath;//封面图

    private String pubType;// 1局通知 2校通知

    private String xx;//学校

    private String nj;//年级

    private Integer lastDay;//发布时长

    private String createTime;//创建时间

    private String publishTime;//发布时间

    private String overTime;//结束时间

    private Boolean isDel;//是否删除

    private String noticeStatus;//消息状态 1已发布 2未发布 3到期

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getPubType() {
        return pubType;
    }

    public void setPubType(String pubType) {
        this.pubType = pubType;
    }

    public String getXx() {
        return xx;
    }

    public void setXx(String xx) {
        this.xx = xx;
    }

    public String getNj() {
        return nj;
    }

    public void setNj(String nj) {
        this.nj = nj;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getOverTime() {
        return overTime;
    }

    public void setOverTime(String overTime) {
        this.overTime = overTime;
    }

    public Boolean getDel() {
        return isDel;
    }

    public void setDel(Boolean del) {
        isDel = del;
    }

    public Integer getLastDay() {
        return lastDay;
    }

    public void setLastDay(Integer lastDay) {
        this.lastDay = lastDay;
    }

    public String getNoticeStatus() {
        return noticeStatus;
    }

    public void setNoticeStatus(String noticeStatus) {
        this.noticeStatus = noticeStatus;
    }
}