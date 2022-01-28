package com.gu.drools.fosunhealth.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class Lcpol implements Serializable {
    /*
    * 险种
    * */
    //险种编码
    private String riskCode;
    //险种名称
    private String riskName;
    //主附险标志
    private String isMainFlag;
    //被保人客户号
    private String insuredNo;
    //保费
    private Double prem;
    //保险年期
    private String years;
    //交费年期
    private String payYears;
    //交费方式
    private String payintv;
    //保额
    private Double amnt;
    //份数
    private Integer mult;
    //险种性质
    private String riskPeriod;
    //险种类别
    private String riskType;
    //停售日期
    private Date endPolApplyDate;
    //起售日期
    private Date startDate;
    //险种计划
    private String riskPlan;
    //险种责任
    private String lcduty;
    //责任编码
    private String dutyCode;
    //险种方案
    private String riskProject;
    //最低投保金额
    private Double minAmnt;
    //险种责任列表
    private ArrayList<Lcduty> lcdutyList = new ArrayList<Lcduty>();


}
