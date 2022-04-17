package com.gu.drools.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@TableName(value = "rule_package")
public class RulePackage {
    private Integer id ;
    private String package_name;
    private String leave;
    private int pid;
    private List<RulePackage> children;
}
