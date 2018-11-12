package com.jovan.model;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {
    private String id;

    private String name;

    private String age;

    private String sex;

    private String mobile;

    private String email;

    private String CREATE_ID;

    private Date CREATE_DATE;

    private String MODIFY_ID;

    private Date MODIFY_DATE;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCREATE_ID() {
        return CREATE_ID;
    }

    public void setCREATE_ID(String CREATE_ID) {
        this.CREATE_ID = CREATE_ID;
    }

    public Date getCREATE_DATE() {
        return CREATE_DATE;
    }

    public void setCREATE_DATE(Date CREATE_DATE) {
        this.CREATE_DATE = CREATE_DATE;
    }

    public String getMODIFY_ID() {
        return MODIFY_ID;
    }

    public void setMODIFY_ID(String MODIFY_ID) {
        this.MODIFY_ID = MODIFY_ID;
    }

    public Date getMODIFY_DATE() {
        return MODIFY_DATE;
    }

    public void setMODIFY_DATE(Date MODIFY_DATE) {
        this.MODIFY_DATE = MODIFY_DATE;
    }
}