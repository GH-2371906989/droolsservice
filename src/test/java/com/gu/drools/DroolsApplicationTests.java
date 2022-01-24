package com.gu.drools;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gu.drools.Vo.ResEntity;
import com.gu.drools.fosunhealth.entity.Lccont;
import com.gu.drools.fosunhealth.entity.Lcinsured;
import com.gu.drools.fosunhealth.entity.Lcpol;
import com.gu.drools.fosunhealth.entity.ResultDto;
import com.gu.drools.mapper.EntityDateMapper;
import org.junit.jupiter.api.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DroolsApplicationTests {
    @Autowired
    private EntityDateMapper entityDateMapper;
    @Autowired
    private KieContainer kieContainer;
    @Test
    void contextLoads() {

    }



    @Test
    public void peoplse() {
        KieSession session = kieContainer.newKieSession();
        ResEntity resEntity = new ResEntity();
        Lcpol lcpol = new Lcpol();
        lcpol.setRiskCode("111");
        resEntity.setLcpol(lcpol);
        session.insert(resEntity.getLcpol());
        ResultDto resultDto = new ResultDto();
        session.insert(resultDto);
        int i = session.fireAllRules();
        System.out.println("i = " + i);
        session.destroy();
    }
}
