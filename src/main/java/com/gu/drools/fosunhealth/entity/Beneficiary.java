package com.gu.drools.fosunhealth.entity;

import java.util.Date;

public class Beneficiary {
      /*
       * 受益人
     * */
    //受益人类别
    private String bnfType="";
    //年龄
    private Integer age=0;
    //出生日期
    private Date birthday;
    //姓名
    private String name="";
    //性别
    private String sex="";
    //与被保人关系
    private String relationToInsured="";
    //证件类型
    private String idType="";
    //手机号码
    private String phoneNum;
    //证件号码
    private String idNo="";
    //证件长期有效标志
    private String isLongValid="";
    //证件有效起期
    private Date beneIdStartDate;
    //证件有效止期
    private Date beneIdEndDate;
    //受益份额
    private Double bnfLot=0.0;

    public String getBnfType() {
        return bnfType;
    }

    public void setBnfType(String bnfType) {
        this.bnfType = bnfType;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRelationToInsured() {
        return relationToInsured;
    }

    public void setRelationToInsured(String relationToInsured) {
        this.relationToInsured = relationToInsured;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public Double getBnfLot() {
        return bnfLot;
    }

    public void setBnfLot(Double bnfLot) {
        this.bnfLot = bnfLot;
    }

    public Date getBeneIdStartDate() {
        return beneIdStartDate;
    }

    public void setBeneIdStartDate(Date beneIdStartDate) {
        this.beneIdStartDate = beneIdStartDate;
    }

    public Date getBeneIdEndDate() {
        return beneIdEndDate;
    }

    public void setBeneIdEndDate(Date beneIdEndDate) {
        this.beneIdEndDate = beneIdEndDate;
    }

    public String getIsLongValid() {
        return isLongValid;
    }

    public void setIsLongValid(String isLongValid) {
        this.isLongValid = isLongValid;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
