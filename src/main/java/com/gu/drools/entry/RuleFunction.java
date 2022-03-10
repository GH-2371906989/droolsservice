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
 * @since 2020-04-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="RuleFunction对象", description="")
public class RuleFunction extends RuleBaseEntity<RuleFunction> {

    private static final long serialVersionUID = 1L;

    private String name;

    @ApiModelProperty(value = "符号在界面上的展示样式")
    private String display;

    @ApiModelProperty(value = "生成SQL时符号的运算法则")
    private String implenmation;

    private String state;

    @ApiModelProperty(value = "String-字符型 Number-数字型 Date-日期型 Time-时间型 HH24:MI:SS ")
    private String commandType;

    private Integer paraNum;

    private String paraType;

    @ApiModelProperty(value = "String-字符型 Number-数字型 Date-日期型 Time-时间型 HH24:MI:SS Boolean-逻辑值 ")
    private String resultType;

    private String description;

    @ApiModelProperty(value = "加载顺序")
    private Integer loadOrder;

    @ApiModelProperty(value = "函数实体")
    private String functionEntity;

    private String functionType;

    private String functionDetail;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String operator;


    @Override
    protected Serializable pkVal() {
        return super.getId();
    }

}
