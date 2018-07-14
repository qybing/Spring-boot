package com.tiye.IntelligentClass.model;

/**
 * 影像馆
 */
public class VideoShop {
    private Long id;//主键
    private String vtype;//资源类型 影视音乐有声读物
    private String title;
    private String author;//作者
    private String desp;//描述
    private String frontCover;//封面图
    private String resourceUrl;//资源地址
    private int iscy;//是否为常用
    private String nj;//适用年级
    private boolean isDel=false;//是否被删除,0表示已经删除，1标识未删除
    private String createTime;//创建时间


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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public String getFrontCover() {
        return frontCover;
    }

    public void setFrontCover(String frontCover) {
        this.frontCover = frontCover;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public int getIscy() {
        return iscy;
    }

    public void setIscy(int iscy) {
        this.iscy = iscy;
    }

    public String getNj() {
        return nj;
    }

    public void setNj(String nj) {
        this.nj = nj;
    }

    public boolean isDel() {
        return isDel;
    }

    public void setDel(boolean del) {
        isDel = del;
    }

    public String getVtype() {
        return vtype;
    }

    public void setVtype(String vtype) {
        this.vtype = vtype;
    }

    public String getDesp() {
        return desp;
    }

    public void setDesp(String desp) {
        this.desp = desp;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
