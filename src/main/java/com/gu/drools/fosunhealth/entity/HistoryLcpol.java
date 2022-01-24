package com.gu.drools.fosunhealth.entity;

import java.util.Date;

public class HistoryLcpol {
    /*
    *既往险种
    * */

    //险种编码
    private String riskCode;
    //核保状态
    private String uwflag;
    //投保单标志
    private String appflag;
    //终止日期
    private Date enddate;
    //责任编码
    private String dutyCode;
    //责任保额
    private Double amnt;
    //险种计划
    private String riskPlan;

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getUwflag() {
        return uwflag;
    }

    public void setUwflag(String uwflag) {
        this.uwflag = uwflag;
    }

    public String getAppflag() {
        return appflag;
    }

    public void setAppflag(String appflag) {
        this.appflag = appflag;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getDutyCode() {
        return dutyCode;
    }

    public void setDutyCode(String dutyCode) {
        this.dutyCode = dutyCode;
    }

    public Double getAmnt() {
        return amnt;
    }

    public void setAmnt(Double amnt) {
        this.amnt = amnt;
    }

    public String getRiskPlan() {
        return riskPlan;
    }

    public void setRiskPlan(String riskPlan) {
        this.riskPlan = riskPlan;
    }
}
