package com.gu.drools.entry;

import lombok.Data;

import java.util.List;

@Data
public class RuleDate {
    private String code;
    private int performType;//规则类型 1：规则引擎 2：决策表
    private List<pRuleCondition> PredefinedList; //规则的预定义/predefined部分
    private List<RuleCondition> rulelist ; //规则的如果/if部分
    private List<RuleCondition> ThenList ; //规则的那么/then部分
    private List<String[]> values;//决策表的值
}
