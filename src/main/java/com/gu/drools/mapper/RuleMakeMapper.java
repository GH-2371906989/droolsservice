package com.gu.drools.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gu.drools.Vo.RuleAttribute;
import com.gu.drools.Vo.RuleShowVo;
import org.apache.ibatis.annotations.Param;

public interface RuleMakeMapper extends BaseMapper<RuleAttribute> {
    RuleShowVo findRuleByCode(@Param("code")String code, @Param("performType")String performType);
}
