package com.gu.drools.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.gu.drools.Vo.ResEntity;
import com.gu.drools.fosunhealth.entity.Lccont;
import com.gu.drools.fosunhealth.entity.Lcinsured;
import com.gu.drools.fosunhealth.entity.Lcpol;
import com.gu.drools.fosunhealth.entity.ResultDto;
import com.gu.drools.mapper.EntityDateMapper;
import com.gu.drools.service.DroolsService;
import org.drools.core.ClassObjectFilter;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;

@RestController
@CrossOrigin
@RequestMapping("drools")
public class TestController {
    @Autowired
    private EntityDateMapper entityDateMapper;
    @Autowired
    private DroolsService droolsService;

    @GetMapping("/getEntity")
    public String getEntity(){
        ResEntity resEntity = new ResEntity();
        resEntity.setLcinsured(new Lcinsured());
        resEntity.setLcpol(new Lcpol());
        resEntity.setLccont(new Lccont());
        return JSONObject.toJSONString(resEntity,
                SerializerFeature.PrettyFormat,
//                SerializerFeature.WriteMapNullValue, //null
                SerializerFeature.WriteNullStringAsEmpty,//String;
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.WriteNullNumberAsZero);
    }
    @PostMapping("/execute")
    public String execute(@RequestBody ResEntity resEntity) throws Exception {
        return droolsService.resuleEntity(resEntity);
    }

    public static void reflect(ResEntity e,KieSession kieSession) throws Exception{

    }
}
