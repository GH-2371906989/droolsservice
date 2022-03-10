package com.gu.drools.drl;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Condition {
    private boolean isWrite = false;
    private List<Param> params = new ArrayList<>();
    private int commadIndex;
    private String jionType;
}
