package com.gu.drools.fosunhealth.entity;

import java.util.Date;

public class Appnt {
    /*
    *投保人
    *
     */
    //年龄
    private Integer age=0;
    //姓名
    private String name="";
    //性别
    private String sex="";
    //出生日期
    private Date birthday;
    //证件类型
    private String idType="";
    //证件号码
    private String idNo="";
    //证件长期有效标志
    private String isLongValid="";
    //证件有效起期
    private Date appntIdStartDate;
    //证件有效止期
    private Date appntIdEndDate;
    //客户号
    private String customerNo="";
    //国籍
    private String nativeplace="";
    //电话
    private String mobile="";
    //邮箱
    private String email="";
    //职业代码
    private String occupationCode="";
    //职业类别
    private String occupationType="";
    //投保人电话对应客户数
    private Integer mobileOfCustomers=0;
    //投保人邮箱对应客户数
    private Integer emailOfCustomers=0;


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getNativeplace() {
        return nativeplace;
    }

    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace;
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

    public String getOccupationCode() {
        return occupationCode;
    }

    public void setOccupationCode(String occupationCode) {
        this.occupationCode = occupationCode;
    }

    public String getOccupationType() {
        return occupationType;
    }

    public void setOccupationType(String occupationType) {
        this.occupationType = occupationType;
    }

    public Integer getMobileOfCustomers() {
        return mobileOfCustomers;
    }

    public void setMobileOfCustomers(Integer mobileOfCustomers) {
        this.mobileOfCustomers = mobileOfCustomers;
    }

    public Integer getEmailOfCustomers() {
        return emailOfCustomers;
    }

    public void setEmailOfCustomers(Integer emailOfCustomers) {
        this.emailOfCustomers = emailOfCustomers;
    }

    public Date getAppntIdStartDate() {
        return appntIdStartDate;
    }

    public void setAppntIdStartDate(Date appntIdStartDate) {
        this.appntIdStartDate = appntIdStartDate;
    }

    public Date getAppntIdEndDate() {
        return appntIdEndDate;
    }

    public void setAppntIdEndDate(Date appntIdEndDate) {
        this.appntIdEndDate = appntIdEndDate;
    }

    public String getIsLongValid() {
        return isLongValid;
    }

    public void setIsLongValid(String isLongValid) {
        this.isLongValid = isLongValid;
    }
}
