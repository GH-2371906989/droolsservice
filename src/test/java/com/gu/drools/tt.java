package com.gu.drools;

import com.alibaba.fastjson.JSON;
import com.gu.drools.mapper.RuleMapper;
import com.gu.drools.mapper.RulePackageMapper;
import com.gu.drools.pojo.Rule;
import com.gu.drools.pojo.RulePackage;
import com.gu.drools.service.RuleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class tt {
    @Autowired
    private RulePackageMapper rulePackageMapper;
    @Autowired
    private RuleMapper ruleMapper;

    @Test
    public void t1(){
        System.out.println(rulePackageMapper);
        List<RulePackage> allPackage = rulePackageMapper.getAllPackage();
        System.out.println("allPackage = " + JSON.toJSONString(allPackage));
    }

    @Test
    public void t2(){
//        Rule rule = ruleMapper.selectById(1);
//        Rule rule = ruleMapper.getRuleById(1)
//        ;
        Rule rule = Rule.builder().id(1).rule("22").pid(1).build();
        int i = ruleMapper.updateById(rule);
        rule = ruleMapper.selectById(1);
        System.out.println("rule = " + JSON.toJSONString(rule));
    }
    @Test
    public void t3(){

    }
}
