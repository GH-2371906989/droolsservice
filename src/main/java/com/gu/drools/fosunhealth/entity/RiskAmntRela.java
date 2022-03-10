package com.gu.drools.fosunhealth.entity;

public class RiskAmntRela {
    /*
    * 累计风险信息
    * */
    //累计风险类型
    private String riskAmntType="";
    //累计风险保额
    private Double riskAmnt=0.0;

    public String getRiskAmntType() {
        return riskAmntType;
    }

    public void setRiskAmntType(String riskAmntType) {
        this.riskAmntType = riskAmntType;
    }

    public Double getRiskAmnt() {
        return riskAmnt;
    }

    public void setRiskAmnt(Double riskAmnt) {
        this.riskAmnt = riskAmnt;
    }
}
