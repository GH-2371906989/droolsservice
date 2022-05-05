package com.gu.drools.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@TableName(value = "jotter")
public class Jotter {
    @TableId
    private int id;
    private String name;
    @TableField("url")
    private String URL;
    @TableField("downloadURL")
    private String downloadURL;
    private String flag;
}
