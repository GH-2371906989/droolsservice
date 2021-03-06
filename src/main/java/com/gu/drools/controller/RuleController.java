package com.gu.drools.controller;

import com.alibaba.fastjson.JSON;
import com.gu.drools.mapper.RuleMapper;
import com.gu.drools.pojo.Rule;
import com.gu.drools.service.RuleService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("drools")
@Slf4j
public class RuleController {
    @Autowired
    private RuleMapper ruleMapper;

    @ApiOperation("获取规则")
    @GetMapping("/getRule/{id}")
    public Rule getRule(@PathVariable("id") Integer id){
        return ruleMapper.selectById(id);
    }
    @ApiOperation("修改规则")
    @PostMapping("/updateRule")
    public Rule updateRule(@RequestBody Rule rule){
        log.info("Rule:{}", JSON.toJSONString(rule));
        int i = ruleMapper.updateById(rule);

        return ruleMapper.selectById(rule.getId());
    }

}
