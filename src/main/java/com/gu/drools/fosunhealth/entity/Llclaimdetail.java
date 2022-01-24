package com.gu.drools.fosunhealth.entity;

public class Llclaimdetail {
    /*
    * 赔付明细
    * */
    //核赔赔付金额
    private Double realPay;
    //年免赔额度
    private Double spyeardedu;
    //赔付结论
    private String giveType;
    //给付责任编码
    private String getDutyCode;
    //责任编码
    private String dutyCode;
    //险种编码
    private String riskCode;

    public Double getRealPay() {
        return realPay;
    }

    public void setRealPay(Double realPay) {
        this.realPay = realPay;
    }

    public Double getSpyeardedu() {
        return spyeardedu;
    }

    public void setSpyeardedu(Double spyeardedu) {
        this.spyeardedu = spyeardedu;
    }

    public String getGiveType() {
        return giveType;
    }

    public void setGiveType(String giveType) {
        this.giveType = giveType;
    }

    public String getGetDutyCode() {
        return getDutyCode;
    }

    public void setGetDutyCode(String getDutyCode) {
        this.getDutyCode = getDutyCode;
    }

    public String getDutyCode() {
        return dutyCode;
    }

    public void setDutyCode(String dutyCode) {
        this.dutyCode = dutyCode;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }
}
