package com.gu.drools.fosunhealth.entity;

import java.util.ArrayList;
import java.util.Date;

public class Lcappnt {
    /*
    * 投保人
    * */
    //客户号
    private String appntNo;
    //性别
    private String sex;
    //出生日期
    private Date birthday;
    //单位名称
    private String grpname;
    //通讯住址
    private String postalAddress;
    //家庭住址
    private String homeAddress;
    //与主被保人关系
    private String relationToMainInsured;
    //证件类型
    private String idType;
    //证件号码
    private String idNo;
    //邮编
    private String zipCode;
    //国籍
    private String nation;
    //姓名
    private String appntName;
    //职业类别
    private String occupationType;
    //职业代码
    private String occupationCode;
    //手机号
    private String mobile;
    //通讯电话
    private String phone;
    //家庭电话
    private String homePhone;
    //公司电话
    private String companyPhone;
    //手机号2
    private String mobile2;
    //县/区
    private String county;
    //县/区(家庭地址)
    private String homeCounty;
    //投保年龄
    private Integer appntAge;
    //政要类黑名单标志
    private String dignitariesBlackFlag;
    //重点关注客户标志
    private String focusOnCustomFlag;
    //与被保人关系
    private String relationtoinsured;
    //手机号重复次数
    private Integer repeatTimes;
    //税前年收入（万元）
    private Double pretaxge;
    //告知列表
    private ArrayList<LcCustomerImpart> lcCustomerImpartList = new ArrayList<LcCustomerImpart>();
    //当地年度居民人均可支配收入

    public String getAppntNo() {
        return appntNo;
    }

    public void setAppntNo(String appntNo) {
        this.appntNo = appntNo;
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

    public String getGrpname() {
        return grpname;
    }

    public void setGrpname(String grpname) {
        this.grpname = grpname;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getRelationToMainInsured() {
        return relationToMainInsured;
    }

    public void setRelationToMainInsured(String relationToMainInsured) {
        this.relationToMainInsured = relationToMainInsured;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getAppntName() {
        return appntName;
    }

    public void setAppntName(String appntName) {
        this.appntName = appntName;
    }

    public String getOccupationType() {
        return occupationType;
    }

    public void setOccupationType(String occupationType) {
        this.occupationType = occupationType;
    }

    public String getOccupationCode() {
        return occupationCode;
    }

    public void setOccupationCode(String occupationCode) {
        this.occupationCode = occupationCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getMobile2() {
        return mobile2;
    }

    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getHomeCounty() {
        return homeCounty;
    }

    public void setHomeCounty(String homeCounty) {
        this.homeCounty = homeCounty;
    }

    public Integer getAppntAge() {
        return appntAge;
    }

    public void setAppntAge(Integer appntAge) {
        this.appntAge = appntAge;
    }

    public String getDignitariesBlackFlag() {
        return dignitariesBlackFlag;
    }

    public void setDignitariesBlackFlag(String dignitariesBlackFlag) {
        this.dignitariesBlackFlag = dignitariesBlackFlag;
    }

    public String getFocusOnCustomFlag() {
        return focusOnCustomFlag;
    }

    public void setFocusOnCustomFlag(String focusOnCustomFlag) {
        this.focusOnCustomFlag = focusOnCustomFlag;
    }

    public String getRelationtoinsured() {
        return relationtoinsured;
    }

    public void setRelationtoinsured(String relationtoinsured) {
        this.relationtoinsured = relationtoinsured;
    }

    public Integer getRepeatTimes() {
        return repeatTimes;
    }

    public void setRepeatTimes(Integer repeatTimes) {
        this.repeatTimes = repeatTimes;
    }

    public Double getPretaxge() {
        return pretaxge;
    }

    public void setPretaxge(Double pretaxge) {
        this.pretaxge = pretaxge;
    }

    public ArrayList<LcCustomerImpart> getLcCustomerImpartList() {
        return lcCustomerImpartList;
    }

    public void setLcCustomerImpartList(ArrayList<LcCustomerImpart> lcCustomerImpartList) {
        this.lcCustomerImpartList = lcCustomerImpartList;
    }
}

