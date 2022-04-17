package com.gu.drools.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.gu.drools.Vo.ResEntity;
import com.gu.drools.fosunhealth.entity.Lcpol;
import com.gu.drools.mapper.RuleMapper;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Service
public class DroolsServiceImpl implements  DroolsService{
/*    @Autowired
    private KieContainer kieContainer;*/
    @Autowired
    private RuleMapper ruleMapper;
    public  KieSession kieSession(){
        KieHelper helper = new KieHelper();
        helper.addContent(ruleMapper.selectById(1).getRule(), ResourceType.DRL);
        return helper.build().newKieSession();
    }


    @Override
    public String resuleEntity( ResEntity resEntity) {
        try {
            KieSession kieSession = this.kieSession();
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
            else {
                Map<String, Object> map = new HashMap<>();
                map.put("success","成功");
                return JSON.toJSONString(map);
            }
        }catch (Exception e){
            Map<String, Object> map = new HashMap<>();
            map.put("错误",e.toString());
            return JSON.toJSONString(map);
        }
    }
}
