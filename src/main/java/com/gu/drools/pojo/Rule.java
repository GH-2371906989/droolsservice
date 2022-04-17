package com.gu.drools.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@TableName(value = "rule")
public class Rule {
    private Integer id ;
    private String rule;
    private int pid;
}
