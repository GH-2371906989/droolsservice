package com.gu.drools.fosunhealth.entity;

import java.util.ArrayList;

public class HistPolicy {
    /*
    * 既往单信息
    * */

    //险种信息列表
    private ArrayList<Product> productList = new ArrayList<Product>();
    //生存调查记录
    private Boolean rnewReport=false;
    //有健康告知异常
    private Boolean healthSpecAImpart=false;
    //生存调查是否完成
    private Boolean rnewReportState=false;
    //核保结论
    private String uwFlag="";
    //是否完成体检
    private Boolean healthAchieve = false;
    //体检结果
    private String healthReportResult="";
    //是否有体检调查记录
    private Boolean sendPENoticeFlag=false;
    //理赔状态
    private String clmState="";
    //理赔报案记录
    private String hasHistoryClaim="";

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }


    public String getUwFlag() {
        return uwFlag;
    }

    public void setUwFlag(String uwFlag) {
        this.uwFlag = uwFlag;
    }

    public String getHealthReportResult() {
        return healthReportResult;
    }

    public void setHealthReportResult(String healthReportResult) {
        this.healthReportResult = healthReportResult;
    }

    public Boolean getSendPENoticeFlag() {
        return sendPENoticeFlag;
    }

    public void setSendPENoticeFlag(Boolean sendPENoticeFlag) {
        this.sendPENoticeFlag = sendPENoticeFlag;
    }

    public String getClmState() {
        return clmState;
    }

    public void setClmState(String clmState) {
        this.clmState = clmState;
    }

    public String getHasHistoryClaim() {
        return hasHistoryClaim;
    }

    public void setHasHistoryClaim(String hasHistoryClaim) {
        this.hasHistoryClaim = hasHistoryClaim;
    }

    public Boolean getRnewReport() {
        return rnewReport;
    }

    public void setRnewReport(Boolean rnewReport) {
        this.rnewReport = rnewReport;
    }

    public Boolean getHealthSpecAImpart() {
        return healthSpecAImpart;
    }

    public void setHealthSpecAImpart(Boolean healthSpecAImpart) {
        this.healthSpecAImpart = healthSpecAImpart;
    }

    public Boolean getRnewReportState() {
        return rnewReportState;
    }

    public void setRnewReportState(Boolean rnewReportState) {
        this.rnewReportState = rnewReportState;
    }

    public Boolean getHealthAchieve() {
        return healthAchieve;
    }

    public void setHealthAchieve(Boolean healthAchieve) {
        this.healthAchieve = healthAchieve;
    }
}
