package com.gu.drools.entry;

import lombok.Data;

import java.util.List;

@Data
public class Function {
    private List<RuleCondition> param;
}
