package com.tiye.IntelligentClass.model;

import java.util.List;

/**
 * 班级相册
 */
public class ClassPhoto {
    private Long id;//主键

    private String title;//标题

    private String content;//内容

    private String xx;//学校

    private String nj;//年级

    private String bj;//班级


    private String createTime;//创建时间

    private List<ClassPhotoPic> pics;

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
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getXx() {
        return xx;
    }

    public void setXx(String xx) {
        this.xx = xx == null ? null : xx.trim();
    }

    public String getNj() {
        return nj;
    }

    public void setNj(String nj) {
        this.nj = nj == null ? null : nj.trim();
    }

    public String getBj() {
        return bj;
    }

    public void setBj(String bj) {
        this.bj = bj == null ? null : bj.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public List<ClassPhotoPic> getPics() {
        return pics;
    }

    public void setPics(List<ClassPhotoPic> pics) {
        this.pics = pics;
    }
}