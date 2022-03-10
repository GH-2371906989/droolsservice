package com.gu.drools.entry;

import lombok.Data;

@Data
public class BomItem {
    private Integer bomId;
    private String cnName;
    private String name;
    private String commandType;
    private String connector;
    private String isBase;
    private String isHierarchical;
    /**
     * N03
     */
    private String preCheck;
    private Integer id;
    private String bomItemKey;
    private String ruleMsg;
    private String bomItemType;
}
