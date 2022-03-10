package com.gu.drools.entry;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class DynamicTableList implements Serializable {
    private List<Map<String,String>> paramList;
}
