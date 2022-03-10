package com.gu.drools.entry;

import lombok.Data;

@Data
public class RuleCommand {
    private String commandType;
    private String display;
    private String implenmation;
    private String name;
    private Integer paraNum;
    private String paraType;
    private Integer id;

    /**
     * resultType 为boolean 时为判断条件 Number时为数值计算
     */
    private String resultType;

    private String ruleCommandKey;//
    private String ruleMsg;//
    private String bomItemType;
}
