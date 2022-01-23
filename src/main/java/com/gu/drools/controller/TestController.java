package com.gu.drools.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.gu.drools.Entity.People;
import com.gu.drools.mapper.EntityDateMapper;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("drools")
public class TestController {
    @Autowired
    private EntityDateMapper entityDateMapper;
    @Autowired
    private KieSession kieSession;
    @GetMapping("/getEntity")
    public String getEntity(){

        return JSONObject.toJSONString(new People(),
                SerializerFeature.WriteMapNullValue, //null
                SerializerFeature.WriteNullStringAsEmpty,//String;
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.WriteNullNumberAsZero);
    }
    @PostMapping("/execute")
    public String execute(@RequestBody People people){
        System.out.println("people = " + people);
        kieSession.insert(people);
        int i = kieSession.fireAllRules();
        if (i>0){
            return JSONObject.toJSONString(people,
                    SerializerFeature.WriteMapNullValue, //null
                    SerializerFeature.WriteNullStringAsEmpty,//String;
                    SerializerFeature.WriteNullListAsEmpty,
                    SerializerFeature.WriteNullBooleanAsFalse,
                    SerializerFeature.WriteNullNumberAsZero);
        }
        else return "{'error','错误'}";

    }
}
