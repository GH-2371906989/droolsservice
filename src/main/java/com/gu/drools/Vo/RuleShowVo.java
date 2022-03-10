package com.gu.drools.Vo;

import com.gu.drools.Vo.base.BaseEntity;
import com.gu.drools.entry.RuleMain;
import lombok.Data;

import java.util.Map;

@Data
public class RuleShowVo extends BaseEntity<RuleMain> {

    private String code;

    private String  decisionRowname;

    private String  decisionTablename;

    private String predefinedDescription;

    private String  whenDescription;

    private String  whenExperssion;

    private String  whenSpecialExperssion;

    private String  thenDesctiption;

    private String  thenExperssion;

    private String  dataType;

    private String  dataGet;

    private String  sqlInfo;

    private String  columnNames;

    private String  columnTypes;

    private String  datatableSource;

    private String  codeVersion;

    private Map<String,Map<String,Object>> useBomParam;


}
