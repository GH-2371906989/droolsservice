package com.gu.drools.entry;

import lombok.Data;

import java.util.List;

@Data
public class RuleCondition {
    private List<ConditionParam> ifSkip;
    private Boolean ifConnType = true;
}
