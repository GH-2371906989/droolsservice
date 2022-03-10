package com.gu.drools.Vo;



import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.gu.drools.Vo.base.RuleBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author aaa
 * @since 2020-04-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class RuleAttribute extends RuleBaseEntity<RuleAttribute> {

    private static final long serialVersionUID = 1L;

    private String code;

    private String ruleBussModu;

    private String ruleBussModuDeta;

    private String pdAttr;

    private String rulePosItem;

    private String ruleAscrCls;

    private String ruleAscrDeta;

    private String description;

    private String remarks;

    private String ruleType;

    private String pdCode;

    private String pdType;

    private String pdEdition;

    private String riskType;

    private String riskDetail;

    private String ruleAttr;

    private String performType;

    private String pdSlChanl;

    private String operator;


    @Override
    protected Serializable pkVal() {
        return super.getId();
    }

}
