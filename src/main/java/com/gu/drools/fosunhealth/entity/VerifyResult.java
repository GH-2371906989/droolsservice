package com.gu.drools.fosunhealth.entity;

public class VerifyResult {
    /*
    * 规则违反信息
    * */
   //违反规则名称
    private String ruleName="";
    //违反规则编码
    private String ruleCode="";
    //提示信息
    private String ruleInfo="";

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public String getRuleInfo() {
        return ruleInfo;
    }

    public void setRuleInfo(String ruleInfo) {
        this.ruleInfo = ruleInfo;
    }
}
