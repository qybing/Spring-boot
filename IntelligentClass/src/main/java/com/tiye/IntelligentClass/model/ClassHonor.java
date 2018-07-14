package com.tiye.IntelligentClass.model;

/**
 * 班级荣誉
 */
public class ClassHonor {
    private Long id;//主键

    private String title;//标题


    private String pic;//图片

    private String xx;//学校

    private String nj;//年级

    private String bj;//班级

    private Boolean isDel;//是否删除

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
        this.title = title == null ? null : title.trim();
    }



    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
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

    public Boolean getDel() {
        return isDel;
    }

    public void setDel(Boolean del) {
        isDel = del;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}