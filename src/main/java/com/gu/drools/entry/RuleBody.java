package com.gu.drools.entry;

import lombok.Data;

import java.util.List;

@Data
public class RuleBody {
    private List<RuleCondition> conditions;
}
