package com.gu.drools.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gu.drools.pojo.RulePackage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RulePackageMapper extends BaseMapper<RulePackage> {

    List<RulePackage> getAllPackage();


}
