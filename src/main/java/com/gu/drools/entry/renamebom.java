package com.gu.drools.entry;

import lombok.Data;

@Data
public class renamebom {
    private String cnName;
    private String name;
    private String bomKey;
    /**
     * 1 bom对象，5 常数
     */
    private String bomType;
    private String ruleMsg;
    private String source;
    private Integer id;
    private String bomLevel;//暂时不知道有啥用
    private Object value;

}
