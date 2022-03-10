package com.gu.drools.entry;


import lombok.Data;

@Data
public class ConditionParam {
    private Bom bom;
    private BomItem bomItem;
    private RuleCommand ruleCommand;
    private RuleFunction func;
    private Function function;
    private InputValue inputValue;
    private Integer LeftParenthesisNumber;
    private Integer rightParenthesisNumber;
    private Integer endParenthesisNumber;
    private Boolean showBomTemp;
    private Boolean showBomItemTemp;
    private Boolean showConstantTemp;
    private Boolean showFuncTemp;
    private Boolean showRuleCommandTemp;
    private Boolean showEndTemp;

}
