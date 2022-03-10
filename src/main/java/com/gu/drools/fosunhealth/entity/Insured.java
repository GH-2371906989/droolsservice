package com.gu.drools.fosunhealth.entity;

import java.util.ArrayList;
import java.util.Date;

public class Insured {
    /*
    * 被保人信息
    * */
    //客户号
    private String sequenceno="";
    //被保人类别
    private String insuredType="";
    //年龄
    private Integer age=0;
    //出生日期
    private Date birthday;
    //姓名
    private String name="";
    //手机号
    private String phoneNum;
    //职业代码
    private String occupationCode="";
    //BMI
    private double bmi=0.0;
    //年收入
    private double income=0.0;
    //理赔报案标记
    private Boolean rptFlag=false;
    //既往异常告知标记
    private Boolean oldSpecAImpart=false;
    //黑名单标记
    private Boolean blackListFlag=false;
    //客户等级
    private String customerLevel="";
    //与投保人关系
    private String relationToAppnt="";
    //与主被保人关系
    private String relationToMainInsured="";
    //险种列表
    private ArrayList<Product> productList = new ArrayList<Product>();
    //职业类别
    private String occupationType="";
    //既往职业类别
    private String pastOccupationType="";
    //吸烟指数
    private String smokeAmount="";
    //证件类型
    private String idType="";
    //证件号码
    private String idNo="";
    //证件长期有效标志
    private String isLongValid="";
    //证件有效起期
    private Date insuredIdStartDate;
    //证件有效止期
    private Date insuredIdEndDate;
    //性别
    private String sex="";
    //既往有体检未完成
    private Boolean unfinishMedical=false;
    //有同业投保高额意外险
    private Boolean highCasualtyFlag=false;
    //受益人列表
    private ArrayList<Beneficiary> beneficiaryList = new ArrayList<Beneficiary>();
    //既往单列表
    private ArrayList<HistPolicy> histPolicyList = new ArrayList<HistPolicy>();
    //累计风险信息列表
    private ArrayList<RiskAmntRela> riskAmntRelaList = new ArrayList<RiskAmntRela>();

    public String getSequenceno() {
        return sequenceno;
    }

    public void setSequenceno(String sequenceno) {
        this.sequenceno = sequenceno;
    }

    public String getInsuredType() {
        return insuredType;
    }

    public void setInsuredType(String insuredType) {
        this.insuredType = insuredType;
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

    public String getOccupationCode() {
        return occupationCode;
    }

    public void setOccupationCode(String occupationCode) {
        this.occupationCode = occupationCode;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public Boolean getRptFlag() {
        return rptFlag;
    }

    public void setRptFlag(Boolean rptFlag) {
        this.rptFlag = rptFlag;
    }

    public Boolean getOldSpecAImpart() {
        return oldSpecAImpart;
    }

    public void setOldSpecAImpart(Boolean oldSpecAImpart) {
        this.oldSpecAImpart = oldSpecAImpart;
    }

    public Boolean getBlackListFlag() {
        return blackListFlag;
    }

    public void setBlackListFlag(Boolean blackListFlag) {
        this.blackListFlag = blackListFlag;
    }

    public String getCustomerLevel() {
        return customerLevel;
    }

    public void setCustomerLevel(String customerLevel) {
        this.customerLevel = customerLevel;
    }

    public String getRelationToAppnt() {
        return relationToAppnt;
    }

    public void setRelationToAppnt(String relationToAppnt) {
        this.relationToAppnt = relationToAppnt;
    }

    public String getRelationToMainInsured() {
        return relationToMainInsured;
    }

    public void setRelationToMainInsured(String relationToMainInsured) {
        this.relationToMainInsured = relationToMainInsured;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public String getOccupationType() {
        return occupationType;
    }

    public void setOccupationType(String occupationType) {
        this.occupationType = occupationType;
    }

    public String getPastOccupationType() {
        return pastOccupationType;
    }

    public void setPastOccupationType(String pastOccupationType) {
        this.pastOccupationType = pastOccupationType;
    }

    public String getSmokeAmount() {
        return smokeAmount;
    }

    public void setSmokeAmount(String smokeAmount) {
        this.smokeAmount = smokeAmount;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public ArrayList<Beneficiary> getBeneficiaryList() {
        return beneficiaryList;
    }

    public void setBeneficiaryList(ArrayList<Beneficiary> beneficiaryList) {
        this.beneficiaryList = beneficiaryList;
    }

    public ArrayList<HistPolicy> getHistPolicyList() {
        return histPolicyList;
    }

    public void setHistPolicyList(ArrayList<HistPolicy> histPolicyList) {
        this.histPolicyList = histPolicyList;
    }

    public ArrayList<RiskAmntRela> getRiskAmntRelaList() {
        return riskAmntRelaList;
    }

    public void setRiskAmntRelaList(ArrayList<RiskAmntRela> riskAmntRelaList) {
        this.riskAmntRelaList = riskAmntRelaList;
    }
    public Boolean getUnfinishMedical() {
        return unfinishMedical;
    }

    public void setUnfinishMedical(Boolean unfinishMedical) {
        this.unfinishMedical = unfinishMedical;
    }

    public Boolean getHighCasualtyFlag() {
        return highCasualtyFlag;
    }

    public void setHighCasualtyFlag(Boolean highCasualtyFlag) {
        this.highCasualtyFlag = highCasualtyFlag;
    }

    public Date getInsuredIdStartDate() {
        return insuredIdStartDate;
    }

    public void setInsuredIdStartDate(Date insuredIdStartDate) {
        this.insuredIdStartDate = insuredIdStartDate;
    }

    public Date getInsuredIdEndDate() {
        return insuredIdEndDate;
    }

    public void setInsuredIdEndDate(Date insuredIdEndDate) {
        this.insuredIdEndDate = insuredIdEndDate;
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
