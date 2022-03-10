package com.gu.drools.service;

import com.gu.drools.entry.RuleDate;
import org.springframework.stereotype.Service;

public interface RuleMakeService {
    public RuleDate toRuleDate(Integer id);
}
