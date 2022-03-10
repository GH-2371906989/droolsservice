package com.gu.drools.drl;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
public class Rule {
    Set<Fact> facts = new LinkedHashSet<>();
    private List<Condition> condition = new ArrayList<>();
    private String drl;
    private String display;
    private Boolean isrule;
}
