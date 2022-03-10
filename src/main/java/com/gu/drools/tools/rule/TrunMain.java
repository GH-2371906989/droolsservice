package com.gu.drools.tools.rule;

import com.gu.drools.drl.*;
import com.gu.drools.entry.*;

import java.util.*;

public class TrunMain extends TrunRule{
    public static Map<String,String> TrunDrl(RuleDate ruleData){
        Map<String,String> map = new HashMap<>();
        int performType = ruleData.getPerformType();

        Rule rule = new Rule();
        Rule then = new Rule();
        element2Condition(rule,then,ruleData.getRulelist(),ruleData.getPredefinedList(),ruleData.getThenList(),performType);

        StringBuilder drl = new StringBuilder();
        drl.append("rule \""+ruleData.getCode()+"\"\r\n");
        drl.append("when\r\n");
        drl.append(rule.getDrl());
        drl.append("then\r\n");
        drl.append("    "+then.getDrl());
        drl.append("\r\nend\r\n");
        System.out.println(drl);

        StringBuilder stringBuilder = new StringBuilder();
        if (performType == 1){
            System.out.println("====================");
            System.out.println(drl);
            stringBuilder.append(drl);
            System.out.println("====================");
        }else if (performType == 2){
            System.out.println("====================");
            for (String[] value : ruleData.getValues()) {
                StringBuilder builder = new StringBuilder();
                builder = new StringBuilder(String.format(drl.toString(), value));
                System.out.println(builder);
                stringBuilder.append(builder+"\r\n");
            }
            System.out.println("====================");
        }

        map.put("drl", stringBuilder.toString());
        return map;
    }

    public static void element2Condition(Rule rule, Rule then, List<RuleCondition> RuleList, List<pRuleCondition> PredefinedList, List<RuleCondition> ThenList, int performType) {
        Set<Fact> facts = new LinkedHashSet<>();
        element2predefined(PredefinedList,facts);
        rule.setIsrule(true);
        rule.setFacts(facts);

        toRule(RuleList,rule,performType,1);
        toDrl(rule);


        then.setIsrule(false);
        toRule(ThenList,then,performType,RuleList.size()+1);
        toDrl(then);
    }

    private static void element2predefined(List<pRuleCondition> PredefinedList,Set<Fact> facts) {
        Rule rule = new Rule();
        PredefinedList.forEach(item->{
            System.out.println("item = " + item);
            Fact fact = new Fact();
            if (item.getBom().getBomLevel().equals("1")){
                fact.setAlis(item.getBom().getCnName());
                fact.setName(item.getBom().getName());
                facts.add(fact);
            }
        });
        PredefinedList.forEach(item->{
            Fact fact = new Fact();
            fact.setAlis(item.getRenamebom().getCnName());
            fact.setName(item.getRenamebom().getName());
            fact.setBomName(item.getBom().getCnName());
            fact.setBomItemName(item.getBomItem().getName());
            facts.add(fact);
        });
    }

}