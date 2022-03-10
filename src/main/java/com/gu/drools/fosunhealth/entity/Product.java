package com.gu.drools.fosunhealth.entity;

public class Product {
    /*
    * 险种信息
    * */
    //险种代码
    private String riskCode="";
    //险种中文名称
    private String riskName="";
    //保单险种号
    private String polNo="";
    //保险期间单位
    private String insuYearFlag="";
    //保险期间
    private Double insuYear=0.0;
    //交费方式
    private String payIntv="";
    //交费期间
    private Double payEndYear=0.0;
    //缴费期间单位
    private String payEndYearFlag="";
    //基本保额
    private Double amnt=0.0;
    //基本保费
    private Double prem=0.0;
    //主附险性质
    private String isMainRiskFlag="";
    //豁免对象
    private String sFreeObject="";
    //豁免险种代码
    private String sFreeCode="";
    //对应主线险种代码
    private String mainRiskCode="";

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getRiskName() {
        return riskName;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName;
    }

    public String getPolNo() {
        return polNo;
    }

    public void setPolNo(String polNo) {
        this.polNo = polNo;
    }

    public String getInsuYearFlag() {
        return insuYearFlag;
    }

    public void setInsuYearFlag(String insuYearFlag) {
        this.insuYearFlag = insuYearFlag;
    }

    public Double getInsuYear() {
        return insuYear;
    }

    public void setInsuYear(Double insuYear) {
        this.insuYear = insuYear;
    }

    public String getPayIntv() {
        return payIntv;
    }

    public void setPayIntv(String payIntv) {
        this.payIntv = payIntv;
    }

    public Double getPayEndYear() {
        return payEndYear;
    }

    public void setPayEndYear(Double payEndYear) {
        this.payEndYear = payEndYear;
    }

    public String getPayEndYearFlag() {
        return payEndYearFlag;
    }

    public void setPayEndYearFlag(String payEndYearFlag) {
        this.payEndYearFlag = payEndYearFlag;
    }

    public Double getAmnt() {
        return amnt;
    }

    public void setAmnt(Double amnt) {
        this.amnt = amnt;
    }

    public Double getPrem() {
        return prem;
    }

    public void setPrem(Double prem) {
        this.prem = prem;
    }

    public String getIsMainRiskFlag() {
        return isMainRiskFlag;
    }

    public void setIsMainRiskFlag(String isMainRiskFlag) {
        this.isMainRiskFlag = isMainRiskFlag;
    }

    public String getsFreeObject() {
        return sFreeObject;
    }

    public void setsFreeObject(String sFreeObject) {
        this.sFreeObject = sFreeObject;
    }

    public String getsFreeCode() {
        return sFreeCode;
    }

    public void setsFreeCode(String sFreeCode) {
        this.sFreeCode = sFreeCode;
    }

    public String getMainRiskCode() {
        return mainRiskCode;
    }

    public void setMainRiskCode(String mainRiskCode) {
        this.mainRiskCode = mainRiskCode;
    }
}
