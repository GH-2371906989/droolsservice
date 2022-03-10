package com.gu.drools.drl;

import lombok.Data;

@Data
public class Param {
    private boolean conditionFlag;
    private String factName;
    private String field;
    private String commad;
    private Object value;
    private String valueType;
    private String display;
    private  String drl;
    private Integer LeftParenthesisNumber;
    private Integer endParenthesisNumber;
}
