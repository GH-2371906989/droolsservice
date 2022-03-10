package com.gu.drools;
import com.gu.drools.fosunhealth.entity.*;

import com.alibaba.fastjson.JSONObject;
import com.gu.drools.Vo.ConsoleVo;
import com.gu.drools.Vo.RuleAttribute;
import com.gu.drools.fosunhealth.entity.Lccont;
import com.gu.drools.fosunhealth.entity.Lcinsured;
import com.gu.drools.fosunhealth.entity.UWDto;
import com.gu.drools.fosunhealth.util.PublicStaticFunctions;
import com.gu.drools.mapper.RuleMakeMapper;
import com.gu.drools.service.RuleMakeService;
import com.jayway.jsonpath.ParseContext;
import org.junit.jupiter.api.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.mvel2.MVEL;
import org.mvel2.ParserContext;
import org.mvel2.integration.impl.MapVariableResolverFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class DroolsApplicationTests {
    @Autowired
    private KieContainer kieContainer;
    @Autowired
    private RuleMakeMapper ruleMakeMapper;
    @Autowired
    private RuleMakeService ruleMakeService;

    @Test
    public void t2() {
        KieSession session = kieContainer.newKieSession();
        Lccont lccont = new Lccont();

        Lcinsured lcinsured = new Lcinsured();
        lcinsured.setName("张三");
        lccont.getLcinsuredList().add(lcinsured);
        Lcinsured lcinsured1 = new Lcinsured();
        lcinsured1.setName("李四");
        lccont.getLcinsuredList().add(lcinsured1);
        session.insert(lccont);
//        session.insert(lcinsured);
        //添加所有规则
        session.fireAllRules();
        //销毁
        session.destroy();
    }

    @Test
    public void t1() throws ParseException {
        System.out.println();

        HashMap<Object, Object> map = new HashMap<>();
        map.put("value", new Lccont());

        String eval = "if(ResultDto(11,22)){" +
                "System.out.println(\"s = \")" +
                "}";

        ParserContext ctx = new ParserContext();
        ctx.addPackageImport("java.util");
        ctx.addPackageImport("java.text");
        Serializable serializable = MVEL.compileExpression(eval, ctx);
        MapVariableResolverFactory factory = new MapVariableResolverFactory();
        String s = "import java.lang.Math;import java.util.Date;\t\n" +
                " function ResultDto(var0,var1){\n" +
                "\t System.out.println(\"var0=======>\"+var0);\n" +
                "\t return true" +
                "}";
        char[] charArr = s.toCharArray();
        System.out.println("s = " + s.toString());
        MVEL.eval(charArr, ctx, factory);

        System.out.println(MVEL.executeExpression(serializable, map, factory));
    }

    @Test
    public void t3() throws ParseException {
        ConsoleVo vo = new ConsoleVo();
        Map<String, Object> vars = new HashMap<>();
        vars.put("var0","11");
        StringBuilder expressionStr = new StringBuilder();

        expressionStr.append("result = ruleInfo(var0);");
        expressionStr.append("return result;");
        PrintStream oldPrintStream = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Object result = null;
        try {
            result = MVEL.eval(expressionStr.toString(),vars);
        } catch (Exception e) {
            e.printStackTrace();
            System.setOut(oldPrintStream);
            System.out.println("result = " + result);
            System.out.println("consoleOut = " + e.getMessage());
        }

        System.setOut(oldPrintStream);
        String consoleOut = bos.toString();
        System.out.println("result = " + result);
        System.out.println("consoleOut = " + consoleOut);
    }

}
