package com.gu.drools.fosunhealth.entity;

public class Lcduty {
    /*
    *险种责任
    * */
    //责任编码
    private String dutyCode;
    //责任保额
    private Double dutyAmnt;
    //年免赔额
    private Double yeardedu;
    //昂贵医院
    private String expensivehospital;
    //保障地域
    private String covertype;
    //门诊责任
    //次免赔额
    private Double subdedu;

    public String getDutyCode() {
        return dutyCode;
    }

    public void setDutyCode(String dutyCode) {
        this.dutyCode = dutyCode;
    }

    public Double getDutyAmnt() {
        return dutyAmnt;
    }

    public void setDutyAmnt(Double dutyAmnt) {
        this.dutyAmnt = dutyAmnt;
    }

    public Double getYeardedu() {
        return yeardedu;
    }

    public void setYeardedu(Double yeardedu) {
        this.yeardedu = yeardedu;
    }

    public String getExpensivehospital() {
        return expensivehospital;
    }

    public void setExpensivehospital(String expensivehospital) {
        this.expensivehospital = expensivehospital;
    }

    public String getCovertype() {
        return covertype;
    }

    public void setCovertype(String covertype) {
        this.covertype = covertype;
    }

    public Double getSubdedu() {
        return subdedu;
    }

    public void setSubdedu(Double subdedu) {
        this.subdedu = subdedu;
    }
}
