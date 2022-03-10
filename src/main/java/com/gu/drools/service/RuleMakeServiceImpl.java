package com.gu.drools.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.gu.drools.Vo.RuleAttribute;
import com.gu.drools.Vo.RuleShowVo;
import com.gu.drools.entry.DynamicTableList;
import com.gu.drools.entry.RuleCondition;
import com.gu.drools.entry.RuleDate;
import com.gu.drools.entry.pRuleCondition;
import com.gu.drools.mapper.RuleMakeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Service

public class RuleMakeServiceImpl implements RuleMakeService {

    @Autowired
    private RuleMakeMapper ruleMakeMapper;

    @Override
    public RuleDate toRuleDate(Integer id) {
        RuleAttribute ruleAttribute = ruleMakeMapper.selectById(id);
        if (ruleAttribute == null){
            return null;
        }
        RuleShowVo rule = ruleMakeMapper.findRuleByCode(ruleAttribute.getCode(), ruleAttribute.getPerformType());RuleDate ruleDate = new RuleDate();
        ruleDate.setCode(rule.getCode());
        ruleDate.setPerformType(Integer.parseInt(ruleAttribute.getPerformType()));
        ruleDate.setRulelist(com.alibaba.fastjson.JSONObject.parseArray(rule.getWhenDescription(), RuleCondition.class));
        ruleDate.setThenList(JSON.parseArray(rule.getThenDesctiption(), RuleCondition.class));
        ruleDate.setPredefinedList(JSON.parseArray(rule.getPredefinedDescription(), pRuleCondition.class ));

        if (Integer.parseInt(ruleAttribute.getPerformType())==2) {
            DynamicTableList DynamicTableList = com.alibaba.fastjson.JSONObject.parseObject(rule.getDataGet(), com.gu.drools.entry.DynamicTableList.class, Feature.OrderedField);
            String[] columnTypes = rule.getColumnTypes().split(",");
            List<String[]> values = new ArrayList<>();
            DynamicTableList.getParamList().forEach(item -> {
                int index = 0;
                String[] strings = new String[columnTypes.length];
                for (Map.Entry<String, String> entry : item.entrySet()) {
                    if (columnTypes[index].equals("String")) {
                        strings[index] = "\"" + entry.getValue() + "\"";
                    } else if (columnTypes[index].equals("Date")) {
                        strings[index] = "new SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\").parse(\"" + entry.getValue() + " 8:0:0\")";
                    } else {
                        strings[index] = entry.getValue();
                    }
                    index++;
                }
                values.add(strings);
            });
            ruleDate.setValues(values);
        }
        return ruleDate;
    }
}
