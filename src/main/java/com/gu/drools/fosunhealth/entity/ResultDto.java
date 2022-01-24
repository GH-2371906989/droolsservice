package com.gu.drools.fosunhealth.entity;

import java.util.ArrayList;

public class ResultDto {
    /*
     * 返回信息
     * */
    //是否测试
    private Boolean isTest=false;
    //校验结果
    private String isApproved="9";
    //规则违反信息列表
    private ArrayList<VerifyResult> verifyResultList = new ArrayList<VerifyResult>();

    public Boolean getTest() {
        return isTest;
    }

    public void setTest(Boolean test) {
        isTest = test;
    }

    public String getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(String isApproved) {
        this.isApproved = isApproved;
    }

    public ArrayList<VerifyResult> getVerifyResultList() {
        return verifyResultList;
    }

    public void setVerifyResultList(ArrayList<VerifyResult> verifyResultList) {
        this.verifyResultList = verifyResultList;
    }
    public void addVerify(String returnInfo , String returnName) {
        VerifyResult result = new VerifyResult();
        result.setRuleInfo(returnInfo);

        result.setRuleName(returnName);
        this.verifyResultList.add(result);
        this.setIsApproved("0");
    }

}
