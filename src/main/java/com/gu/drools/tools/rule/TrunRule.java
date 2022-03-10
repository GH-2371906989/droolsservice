package com.gu.drools.tools.rule;



import com.gu.drools.drl.*;
import com.gu.drools.entry.*;


import java.util.List;

public class TrunRule {

    protected static void toRule(List<RuleCondition> list, Rule rule, int performType, int index) {
        int i = 0;
        for (RuleCondition ruleCondition : list) {
            List<ConditionParam> conditionParams = ruleCondition.getIfSkip();
            boolean flag = true;
            Condition condition = new Condition();
            if (!ruleCondition.getIfConnType() || i == 0) {
                condition.setJionType("并且");
            } else {
                condition.setJionType("或者");
            }
            i++;
            for (ConditionParam conditionParam : conditionParams) {
                if (performType == 2){
                    Boolean isend = changeDynamicRule(rule, conditionParam, flag, condition, index);
                    if (isend == true){
                        index = index +1;
                    }
                }else{
                    changeRule(rule, conditionParam, flag, condition);
                }
                flag = false;
            }
            rule.getCondition().add(condition);
        }
    }

    protected static Boolean changeDynamicRule(Rule rule, ConditionParam conditionParam, boolean flag, Condition condition,int index) {
        Boolean isend = false;
        Param param = new Param();
        param.setConditionFlag(flag);
        String display = "";
        StringBuilder drl=new StringBuilder();
        //左括号
        int LeftParenthesisNumber = conditionParam.getLeftParenthesisNumber();
        for (int i=0;i<LeftParenthesisNumber;i++){
            display +="(";
            drl.append("(");
        }

        Bom bom = conditionParam.getBom();
        //普通bom
        if (conditionParam.getShowBomItemTemp()==true&&bom.getBomKey()!="") {
            if(bom.getIsPre() == null){
                Fact fact = new Fact();
                fact.setAlis(bom.getCnName());
                fact.setName(bom.getName());
                rule.getFacts().add(fact);
                drl.append(bom.getName()+".");
            }else {
                drl.append(bom.getCnName()+".");
            }
            display += bom.getCnName()+" ";
            param.setFactName(bom.getName());
        }

        //bomiten部分
        BomItem bomItem = conditionParam.getBomItem();
        if (conditionParam.getShowBomItemTemp()==true&&bomItem.getBomItemKey() != "") {
            param.setValueType(bomItem.getCommandType());
            param.setField(bomItem.getName());
            if (bomItem.getConnector() == null) {
                bomItem.setConnector("的");
            }
            drl.append(bomItem.getName());
            display += bomItem.getConnector() + bomItem.getCnName()+" ";
        }
        //右括号
        Integer rightParenthesisNumber = conditionParam.getRightParenthesisNumber();
        for (int i=0;i<rightParenthesisNumber;i++){
            display +=")";
            drl.append(")");
        }

        //方法部分
        RuleFunction func = conditionParam.getFunc();
        if (conditionParam.getShowFuncTemp()==true) { //
            display += func.getDisplay();
            drl.append(func.getName());
            List<RuleCondition> funcParam = conditionParam.getFunction().getParam();
            Rule funcRule = new Rule();
            toRule(funcParam,funcRule,2,index);
            int j = 0;
            drl.append("(");
            display +="(";
            for (Condition fcondition :funcRule.getCondition()){
                j++;
                for (Param pparam : fcondition.getParams()) {
                    drl.append(pparam.getDrl());
                    display +=pparam.getDisplay();
                }
                if (j < funcRule.getCondition().size()){
                    drl.append(",");
                    display +=",";
                }
            }
            drl.append(") ");
            display +=") ";


//            param.setConditions(funcRule.getCondition());
            param.setValueType(func.getCommandType());
        }
        //常数部分
        if(conditionParam.getShowConstantTemp()!=null && bom.getBomType()!=null && bom.getBomType().equals("5") && bom.getValue()!=null){
            if (conditionParam.getShowConstantTemp()==true){
                param.setValue(bom.getValue());
                display += bom.getValue();
                drl.append(bom.getValue());
            }
        }

        //连接词部分
        RuleCommand ruleCommand = conditionParam.getRuleCommand();
        if (conditionParam.getShowRuleCommandTemp()==true){
            param.setCommad(ruleCommand.getImplenmation());
            param.setValueType(ruleCommand.getParaType());
            if ("Boolean".equals(ruleCommand.getResultType())) {
                condition.setCommadIndex(condition.getParams().size());
            }
            drl.append(ruleCommand.getImplenmation());
            display += ruleCommand.getDisplay()+" ";
        }

        //请输入部分
        InputValue inputValue = conditionParam.getInputValue();
        if(inputValue.getType() != null){
            param.setValue(inputValue.getValue());
            if (inputValue.getType().equals("Select")){
                drl.append('"'+inputValue.getCode()+'"');
                display += inputValue.getValue();
            }else if (inputValue.getType().equals("String")){
                drl.append('"'+inputValue.getValue()+'"');
                display +='"'+ inputValue.getValue()+'"';
            }else if (inputValue.getType().equals("Date")) {
                String  parse = "new SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\").parse(\""+inputValue.getValue()+" 8:0:0\")";
                drl.append(parse);
                display +='"'+ inputValue.getValue()+'"';
            }else {
                drl.append(inputValue.getValue());
                display +=inputValue.getValue();
            }
        }else if(conditionParam.getShowEndTemp()==true){
            drl.append("%"+index+"$s");
            display += "结束部分";
            isend = true;
        }

        //结束括号
        Integer endParenthesisNumber = conditionParam.getEndParenthesisNumber();
        for (int i=0;i<endParenthesisNumber;i++){
            display +=")";
            drl.append(")");
        }

        param.setDisplay(display);
        param.setDrl(drl.toString());
        condition.getParams().add(param);
        return isend;

    }

    protected static void changeRule(Rule rule, ConditionParam conditionParam, boolean flag, Condition condition) {
        Param param = new Param();
        param.setConditionFlag(flag);

        String display = "";
        StringBuilder drl=new StringBuilder();

        RuleCommand ruleCommand = conditionParam.getRuleCommand();
        if (ruleCommand.getId() != null) {
            param.setCommad(ruleCommand.getImplenmation());
            param.setValueType(ruleCommand.getParaType());
            if ("Boolean".equals(ruleCommand.getResultType())) {
                condition.setCommadIndex(condition.getParams().size());
            }
            drl.append(" "+ruleCommand.getImplenmation()+" ");
            display += ruleCommand.getDisplay()+" ";
        }
        int LeftParenthesisNumber = conditionParam.getLeftParenthesisNumber();
        for (int i=0;i<LeftParenthesisNumber;i++){
            display +="(";
            drl.append("(");
        }
        Bom bom = conditionParam.getBom();
        //普通bom
        if ("1".equals(bom.getBomType())) {
            if(bom.getIsPre() == null){
                Fact fact = new Fact();
                fact.setAlis(bom.getCnName());
                fact.setName(bom.getName());
                rule.getFacts().add(fact);
                drl.append(bom.getCnName()+".");
            }else {
                drl.append(bom.getCnName()+".");
            }
            display += bom.getCnName()+" ";
            param.setFactName(bom.getName());


        } else if ("5".equals(bom.getBomType())) { //常数
            param.setValue(bom.getValue());
            display += bom.getValue();
            drl.append(bom.getValue());
        }

        //bomitem
        BomItem bomItem = conditionParam.getBomItem();
        if (bomItem.getBomId() != null) {
            param.setValueType(bomItem.getCommandType());
            param.setField(bomItem.getName());
            if (bomItem.getConnector() == null) {
                bomItem.setConnector("的");
            }
            drl.append(bomItem.getName());
            display += bomItem.getConnector() + bomItem.getCnName()+" ";
        }

        int rightParenthesisNumber =conditionParam.getRightParenthesisNumber();
        for (int i=0;i<rightParenthesisNumber;i++){
            display +=")";
            drl.append(")");
        }

        RuleFunction func = conditionParam.getFunc();
        if (func.getName() != null) { //
            display += func.getDisplay();
            drl.append(func.getName());
            List<RuleCondition> funcParam = conditionParam.getFunction().getParam();
            Rule funcRule = new Rule();
            toRule(funcParam,funcRule,1,0);
            int j = 0;
            drl.append("(");
            display +="(";
            for (Condition fcondition :funcRule.getCondition()){
                j++;
                for (Param pparam : fcondition.getParams()) {
                    drl.append(pparam.getDrl());
                    display +=pparam.getDisplay();
                }
                if (j < funcRule.getCondition().size()){
                    drl.append(",");
                    display +=",";
                }
            }
            drl.append(") ");
            display +=") ";
//            param.setConditions(funcRule.getCondition());
            param.setValueType(func.getCommandType());
        }

        //结束值
        InputValue inputValue = conditionParam.getInputValue();
        if(inputValue.getType() != null){
            param.setValue(inputValue.getValue());
            if (inputValue.getType().equals("Select")){
                drl.append('"'+inputValue.getCode()+'"');
                display += inputValue.getValue();
            }if (inputValue.getType().equals("multiple")){
                drl.append("( "+inputValue.getCode()+" )");
                display += inputValue.getValue();
            }else if (inputValue.getType().equals("String")){
                drl.append('"'+inputValue.getValue()+'"');
                display +='"'+ inputValue.getValue()+'"';
            }else if (inputValue.getType().equals("Date")) {
                String  parse = "new SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\").parse(\""+inputValue.getValue()+" 8:0:0\")";
                drl.append(parse);
                display +='"'+ inputValue.getValue()+'"';
            }else {
                drl.append(inputValue.getValue());
                display +=inputValue.getValue();
            }
        }

        int endParenthesisNumber =conditionParam.getEndParenthesisNumber();
        for (int i=0;i<endParenthesisNumber;i++){
            display +=")";
            drl.append(")");
        }

        param.setDisplay(display);
        param.setDrl(drl.toString());
        condition.getParams().add(param);
    }

    protected static void toDrl(Rule rule) {
        int i = 0;
        String display = "";
        for (Condition condition : rule.getCondition()) {
            if (i != 0) {
                display += condition.getJionType() + " ";
            }
            i++;
            for (Param param : condition.getParams()) {
                display += param.getDisplay();
            }
            display += "\r\n";
        }
        rule.setDisplay(display);

        StringBuilder drl=new StringBuilder();
        for(Fact fact:rule.getFacts()){
            drl.append("    "+fact.getAlis());
            drl.append(" : ");
            drl.append(fact.getName());
            drl.append("( )");
            if (fact.getBomName() != null && fact.getBomItemName() != null){
                drl.append(" from "+fact.getBomName()+"."+fact.getBomItemName());
            }
            drl.append("\n");
        }
        if (rule.getIsrule()){
            drl.append("    eval( ");
        }
        int cindex = 0;
        for (Condition condition : rule.getCondition()) {
            if(cindex != 0){
                if (condition.getJionType().equals("并且")) {
                    drl.append(" &&\r\n    ");
                } else {
                    drl.append(" ||\r\n    ");
                }
            }
            cindex ++;
            for (Param param : condition.getParams()) {
                drl.append(param.getDrl());
            }
        }
        if (rule.getIsrule()){
            drl.append(" )\n");
        }
        rule.setDrl(drl.toString());
    }


}