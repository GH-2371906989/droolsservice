package com.gu.drools.fosunhealth.entity;

import java.util.ArrayList;
import java.util.Date;

public class PolicyInfo {

    /*
    *个单信息
    *
     */
    //投保日期
    private Date applyDate;
    //失效日期
    private Date endDate;
    //生效日期
    private Date cvaliDate;
    //投保人
    private Appnt appnt = new Appnt();
    //被保人列表
    private ArrayList<Insured> insuredList = new ArrayList<Insured>();

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCvaliDate() {
        return cvaliDate;
    }

    public void setCvaliDate(Date cvaliDate) {
        this.cvaliDate = cvaliDate;
    }

    public Appnt getAppnt() {
        return appnt;
    }

    public void setAppnt(Appnt appnt) {
        this.appnt = appnt;
    }

    public ArrayList<Insured> getInsuredList() {
        return insuredList;
    }

    public void setInsuredList(ArrayList<Insured> insuredList) {
        this.insuredList = insuredList;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }
}
