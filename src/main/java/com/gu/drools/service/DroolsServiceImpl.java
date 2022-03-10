package com.gu.drools.service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.gu.drools.Vo.ResEntity;
import com.gu.drools.fosunhealth.entity.Lcpol;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class DroolsServiceImpl implements  DroolsService{
    @Autowired
    private KieContainer kieContainer;

    @Override
    public String resuleEntity( ResEntity resEntity) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(resEntity.getLccont());
        kieSession.insert(resEntity.getUwDto());
        System.out.println("resEntity = " + resEntity);
        int i = kieSession.fireAllRules();
        kieSession.destroy();
        if (i>0){
            return JSONObject.toJSONString(resEntity.getUwDto(),
                    SerializerFeature.WriteMapNullValue, //null
                    SerializerFeature.WriteNullStringAsEmpty,//String;
                    SerializerFeature.WriteNullListAsEmpty,
                    SerializerFeature.WriteNullBooleanAsFalse,
                    SerializerFeature.WriteNullNumberAsZero);
        }
        else return "{'error','错误'}";
    }
}
