package com.gu.drools.fosunhealth.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class Lccont {

    /*
    * 个人保单
    * */

    //保单号
    private String contNo;
    //投保单号
    private String proposalNo;
    //系统
    private String system;
    //子系统
    private String SubSystem;
    //业务模块
    private String businessModule;
    //交费方式
    private String payintv;
    //首期银行账户号码
    private String newBankAccNo;
    //首期银行编码
    private String NewBankCode;
    //首期银行账户名称
    private String newBankAccName;
    //交费期间
    private String PayEndYear;
    //交费期间单位
    private String PayEndYearFlag ;
    //首期交费方式
    private String newPayMode ;
    //交互式核保标志
    private String isinterationcheck ;
    //保单来源
    private String iscoreflag ;
    //投保申请日期
    private Date polApplyDate ;
    //生效日期
    private Date cvaliDate ;
    //投续转保标记
    private String AppRwReinFlag ;
    //创建日期
    private Date makeDate ;
    //家庭单类型
    private String familyType ;
    //电子保单标记
    private String contPrintFlag ;
    //存在续保记录
    private String hasRenewalFlag ;
    //商户渠道
    private String trdingChannel ;
    //强制人工核保标志
    private String forceUWFlag ;
    //有下发问题件标志
    private String hasIssueProblemFlag ;
    //存在特别约定标志
    private String existSpecFlag ;
    //总单类型
    private String ContType ;
    //客户健康告知异常标志
    private String abnormalHealthImpartFlag ;
    //非见费标志
    private String noPayPremFlag ;
    //续保期间内有本产品理赔记录
    private String hasClaimInRenewal ;
    //续保期间内有其他产品理赔记录
    private String hasOtherClaimInRenewal ;
    //续保期间内有黑名单记录
    private String hasBlackINRenewal ;
    //续保期间内有拒保、延期或非标准承保记录
    private String hasUwflagInRenewal ;
    //既往保单存在加费记录
    private String existIncrease ;
    //上一年度保单存在加费记录
    private String lastYearHasIncrease ;
    //业务线
    private String serviceLine ;
    //客户有既往半年内未回复的问题件标志
    private String hasNoResponseFlag ;
    //投保人列表
    private ArrayList<Lcappnt> lcappntList = new ArrayList<Lcappnt>();
    //被保人列表
    private ArrayList<Lcinsured> lcinsuredList = new ArrayList<Lcinsured>();
    //代理人
    private Laagent agent = new Laagent();


}
