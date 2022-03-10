package com.gu.drools.entry;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.gu.drools.Vo.base.RuleBaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author mizepeng
 * @since 2020-04-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="RuleMain对象", description="")
public class RuleMain extends RuleBaseEntity<RuleMain> {

    private static final long serialVersionUID = 1L;

    private String code;

    private Integer codeVersion;

    private String decisionTableName;

    private String decisionRowName;

    private Integer whenThenNum;

    private String auditIdea;

    private String datatableSource;
    //1-规则定义 2-规则测试 3-规则审批  4-规则发布
    private String node;

    private String sqlInfo;

    @ApiModelProperty(value = "0-定义 1-测试 2-修改 3-审核 4-发布")
    @TableField("state")
    private String state;

    private String performType;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String operator;


    @Override
    protected Serializable pkVal() {
        return super.getId();
    }

}
