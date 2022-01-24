package com.gu.drools.fosunhealth.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class Lcbnf {
    /*
    * 受益人
    * */
    //受益类型
    private String bnfType;
    //受益人客户号
    private String bnfNo;
    //被保人客户号
    private String insuredNo;
    //受益比例
    private Double bnfLot;
    //等级
    private String bnfGrade;
    //与被保人关系
    private String relationToInsured;
    //身份
    private String remark;
    //姓名
    private String name;
    //政要类黑名单标志
    private String dignitariesBlackFlag;
    //重点关注客户标志
    private String focusOnCustomFlag;


}
