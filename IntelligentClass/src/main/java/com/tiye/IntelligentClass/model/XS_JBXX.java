package com.tiye.IntelligentClass.model;

//学生基本信息
public class XS_JBXX {
    //学生基本信息ID
    private String xsJbxxId;
    //个人标识码
    private String grbsm;
    //学校基本信息ID
    private String xxJbxxId;
    //学校名称
    private String xxJbxxZh;
    //
    private String xxNjxxId;
    //年级名称
    private String xxNjxxZh;

    private String xxBjxxId;
    //班级名称
    private String xxBjxxZh;
    //学籍辅号
    private String xjfh;
    //班内学号
    private String bnxh;
    //姓名
    private String xm;
    //性别代码
    private String xbm;
    //性别名称
    private String xbZh;
    //出生日期
    private String csrq;
    //籍贯
    private String jg;
    //籍贯名称
    private String jgZh;
    //家庭住址
    private String jtzz;
    //户口所在地码
    private String hkszdm;
    //户口所在地名称
    private String hkszdmZh;
    //入学年月
    private String rxny;
    //英文姓名
    private String ywxm;
    //身份证件类型码
    private String sfzjlxm;
    //身份证件类型名称
    private String sfzjlxZh;
    //身份证号
    private String sfzjh;
    //行政区划
    private String xzqh;

    private String lrr;

    private String lrsj;

    private String gxr;

    private String gxsj;
    //学生状态
    private String xszt;
    //学生状态名称
    private String xsztZh;
    //民族码
    private String mzm;
    //国籍/地区码
    private String gjdqm;
    //港澳台侨外码
    private String gatqwm;
    //户口性质
    private String hkxzm;
    //政治面貌码
    private String zzmmm;
    //健康状况码
    private String jkzkm;
    //入学方式
    private String rxfsm;
    //就读方式
    private String jdfsm;
    //现住址
    private String xzz;
    //通讯地址
    private String txdz;
    //邮政编码
    private String yzbm;
    //是否进城务工人员随迁子女
    private String sfsqznm;
    //是否独生子女
    private String sfdsznm;
    //是否受过学前教育
    private String sfsgxqjym;
    //是否留守儿童
    private String sflsetm;
    //是否孤儿
    private String sfge;
    //是否烈士或优抚子女
    private String sflshyfzn;
    //是否需要申请资助
    private String sfxsyb;
    //是否享受一补
    private String sfxsybm;
    //联系电话
    private String lxdh;
    //出生地
    private String csd;

    public XS_JBXX(String xsJbxxId, String grbsm, String xxJbxxId, String xxJbxxZh, String xxNjxxId, String xxNjxxZh, String xxBjxxId, String xxBjxxZh, String xjfh, String bnxh, String xm, String xbm, String xbZh, String csrq, String jg, String jgZh, String jtzz, String hkszdm, String hkszdmZh, String rxny, String ywxm, String sfzjlxm, String sfzjlxZh, String sfzjh, String xzqh, String lrr, String lrsj, String gxr, String gxsj, String xszt, String xsztZh, String mzm, String gjdqm, String gatqwm, String hkxzm, String zzmmm, String jkzkm, String rxfsm, String jdfsm, String xzz, String txdz, String yzbm, String sfsqznm, String sfdsznm, String sfsgxqjym, String sflsetm, String sfge, String sflshyfzn, String sfxsyb, String sfxsybm, String lxdh, String csd) {
        this.xsJbxxId = xsJbxxId;
        this.grbsm = grbsm;
        this.xxJbxxId = xxJbxxId;
        this.xxJbxxZh = xxJbxxZh;
        this.xxNjxxId = xxNjxxId;
        this.xxNjxxZh = xxNjxxZh;
        this.xxBjxxId = xxBjxxId;
        this.xxBjxxZh = xxBjxxZh;
        this.xjfh = xjfh;
        this.bnxh = bnxh;
        this.xm = xm;
        this.xbm = xbm;
        this.xbZh = xbZh;
        this.csrq = csrq;
        this.jg = jg;
        this.jgZh = jgZh;
        this.jtzz = jtzz;
        this.hkszdm = hkszdm;
        this.hkszdmZh = hkszdmZh;
        this.rxny = rxny;
        this.ywxm = ywxm;
        this.sfzjlxm = sfzjlxm;
        this.sfzjlxZh = sfzjlxZh;
        this.sfzjh = sfzjh;
        this.xzqh = xzqh;
        this.lrr = lrr;
        this.lrsj = lrsj;
        this.gxr = gxr;
        this.gxsj = gxsj;
        this.xszt = xszt;
        this.xsztZh = xsztZh;
        this.mzm = mzm;
        this.gjdqm = gjdqm;
        this.gatqwm = gatqwm;
        this.hkxzm = hkxzm;
        this.zzmmm = zzmmm;
        this.jkzkm = jkzkm;
        this.rxfsm = rxfsm;
        this.jdfsm = jdfsm;
        this.xzz = xzz;
        this.txdz = txdz;
        this.yzbm = yzbm;
        this.sfsqznm = sfsqznm;
        this.sfdsznm = sfdsznm;
        this.sfsgxqjym = sfsgxqjym;
        this.sflsetm = sflsetm;
        this.sfge = sfge;
        this.sflshyfzn = sflshyfzn;
        this.sfxsyb = sfxsyb;
        this.sfxsybm = sfxsybm;
        this.lxdh = lxdh;
        this.csd = csd;
    }

    public XS_JBXX() {
        super();
    }

    public String getXsJbxxId() {
        return xsJbxxId;
    }

    public void setXsJbxxId(String xsJbxxId) {
        this.xsJbxxId = xsJbxxId;
    }

    public String getGrbsm() {
        return grbsm;
    }

    public void setGrbsm(String grbsm) {
        this.grbsm = grbsm;
    }

    public String getXxJbxxId() {
        return xxJbxxId;
    }

    public void setXxJbxxId(String xxJbxxId) {
        this.xxJbxxId = xxJbxxId;
    }

    public String getXxJbxxZh() {
        return xxJbxxZh;
    }

    public void setXxJbxxZh(String xxJbxxZh) {
        this.xxJbxxZh = xxJbxxZh;
    }

    public String getXxNjxxId() {
        return xxNjxxId;
    }

    public void setXxNjxxId(String xxNjxxId) {
        this.xxNjxxId = xxNjxxId;
    }

    public String getXxNjxxZh() {
        return xxNjxxZh;
    }

    public void setXxNjxxZh(String xxNjxxZh) {
        this.xxNjxxZh = xxNjxxZh;
    }

    public String getXxBjxxId() {
        return xxBjxxId;
    }

    public void setXxBjxxId(String xxBjxxId) {
        this.xxBjxxId = xxBjxxId;
    }

    public String getXxBjxxZh() {
        return xxBjxxZh;
    }

    public void setXxBjxxZh(String xxBjxxZh) {
        this.xxBjxxZh = xxBjxxZh;
    }

    public String getXjfh() {
        return xjfh;
    }

    public void setXjfh(String xjfh) {
        this.xjfh = xjfh;
    }

    public String getBnxh() {
        return bnxh;
    }

    public void setBnxh(String bnxh) {
        this.bnxh = bnxh;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getXbm() {
        return xbm;
    }

    public void setXbm(String xbm) {
        this.xbm = xbm;
    }

    public String getXbZh() {
        return xbZh;
    }

    public void setXbZh(String xbZh) {
        this.xbZh = xbZh;
    }

    public String getCsrq() {
        return csrq;
    }

    public void setCsrq(String csrq) {
        this.csrq = csrq;
    }

    public String getJg() {
        return jg;
    }

    public void setJg(String jg) {
        this.jg = jg;
    }

    public String getJgZh() {
        return jgZh;
    }

    public void setJgZh(String jgZh) {
        this.jgZh = jgZh;
    }

    public String getJtzz() {
        return jtzz;
    }

    public void setJtzz(String jtzz) {
        this.jtzz = jtzz;
    }

    public String getHkszdm() {
        return hkszdm;
    }

    public void setHkszdm(String hkszdm) {
        this.hkszdm = hkszdm;
    }

    public String getHkszdmZh() {
        return hkszdmZh;
    }

    public void setHkszdmZh(String hkszdmZh) {
        this.hkszdmZh = hkszdmZh;
    }

    public String getRxny() {
        return rxny;
    }

    public void setRxny(String rxny) {
        this.rxny = rxny;
    }

    public String getYwxm() {
        return ywxm;
    }

    public void setYwxm(String ywxm) {
        this.ywxm = ywxm;
    }

    public String getSfzjlxm() {
        return sfzjlxm;
    }

    public void setSfzjlxm(String sfzjlxm) {
        this.sfzjlxm = sfzjlxm;
    }

    public String getSfzjlxZh() {
        return sfzjlxZh;
    }

    public void setSfzjlxZh(String sfzjlxZh) {
        this.sfzjlxZh = sfzjlxZh;
    }

    public String getSfzjh() {
        return sfzjh;
    }

    public void setSfzjh(String sfzjh) {
        this.sfzjh = sfzjh;
    }

    public String getXzqh() {
        return xzqh;
    }

    public void setXzqh(String xzqh) {
        this.xzqh = xzqh;
    }

    public String getLrr() {
        return lrr;
    }

    public void setLrr(String lrr) {
        this.lrr = lrr;
    }

    public String getLrsj() {
        return lrsj;
    }

    public void setLrsj(String lrsj) {
        this.lrsj = lrsj;
    }

    public String getGxr() {
        return gxr;
    }

    public void setGxr(String gxr) {
        this.gxr = gxr;
    }

    public String getGxsj() {
        return gxsj;
    }

    public void setGxsj(String gxsj) {
        this.gxsj = gxsj;
    }

    public String getXszt() {
        return xszt;
    }

    public void setXszt(String xszt) {
        this.xszt = xszt;
    }

    public String getXsztZh() {
        return xsztZh;
    }

    public void setXsztZh(String xsztZh) {
        this.xsztZh = xsztZh;
    }

    public String getMzm() {
        return mzm;
    }

    public void setMzm(String mzm) {
        this.mzm = mzm;
    }

    public String getGjdqm() {
        return gjdqm;
    }

    public void setGjdqm(String gjdqm) {
        this.gjdqm = gjdqm;
    }

    public String getGatqwm() {
        return gatqwm;
    }

    public void setGatqwm(String gatqwm) {
        this.gatqwm = gatqwm;
    }

    public String getHkxzm() {
        return hkxzm;
    }

    public void setHkxzm(String hkxzm) {
        this.hkxzm = hkxzm;
    }

    public String getZzmmm() {
        return zzmmm;
    }

    public void setZzmmm(String zzmmm) {
        this.zzmmm = zzmmm;
    }

    public String getJkzkm() {
        return jkzkm;
    }

    public void setJkzkm(String jkzkm) {
        this.jkzkm = jkzkm;
    }

    public String getRxfsm() {
        return rxfsm;
    }

    public void setRxfsm(String rxfsm) {
        this.rxfsm = rxfsm;
    }

    public String getJdfsm() {
        return jdfsm;
    }

    public void setJdfsm(String jdfsm) {
        this.jdfsm = jdfsm;
    }

    public String getXzz() {
        return xzz;
    }

    public void setXzz(String xzz) {
        this.xzz = xzz;
    }

    public String getTxdz() {
        return txdz;
    }

    public void setTxdz(String txdz) {
        this.txdz = txdz;
    }

    public String getYzbm() {
        return yzbm;
    }

    public void setYzbm(String yzbm) {
        this.yzbm = yzbm;
    }

    public String getSfsqznm() {
        return sfsqznm;
    }

    public void setSfsqznm(String sfsqznm) {
        this.sfsqznm = sfsqznm;
    }

    public String getSfdsznm() {
        return sfdsznm;
    }

    public void setSfdsznm(String sfdsznm) {
        this.sfdsznm = sfdsznm;
    }

    public String getSfsgxqjym() {
        return sfsgxqjym;
    }

    public void setSfsgxqjym(String sfsgxqjym) {
        this.sfsgxqjym = sfsgxqjym;
    }

    public String getSflsetm() {
        return sflsetm;
    }

    public void setSflsetm(String sflsetm) {
        this.sflsetm = sflsetm;
    }

    public String getSfge() {
        return sfge;
    }

    public void setSfge(String sfge) {
        this.sfge = sfge;
    }

    public String getSflshyfzn() {
        return sflshyfzn;
    }

    public void setSflshyfzn(String sflshyfzn) {
        this.sflshyfzn = sflshyfzn;
    }

    public String getSfxsyb() {
        return sfxsyb;
    }

    public void setSfxsyb(String sfxsyb) {
        this.sfxsyb = sfxsyb;
    }

    public String getSfxsybm() {
        return sfxsybm;
    }

    public void setSfxsybm(String sfxsybm) {
        this.sfxsybm = sfxsybm;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public String getCsd() {
        return csd;
    }

    public void setCsd(String csd) {
        this.csd = csd;
    }
}