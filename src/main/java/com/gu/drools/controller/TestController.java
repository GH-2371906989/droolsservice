package com.gu.drools.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.gu.drools.Vo.ResEntity;
import com.gu.drools.fosunhealth.entity.Lccont;
import com.gu.drools.fosunhealth.entity.Lcinsured;
import com.gu.drools.fosunhealth.entity.Lcpol;
import com.gu.drools.fosunhealth.entity.ResultDto;
import com.gu.drools.service.DroolsService;
import org.drools.core.ClassObjectFilter;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
@CrossOrigin
@RequestMapping("drools")
public class TestController {
    @Autowired
    private DroolsService droolsService;

    @GetMapping("/getEntity")
    public String getEntity() throws Exception {
        ResEntity resEntity = new ResEntity();
        Lcpol lcpol = new Lcpol();
        Lccont lccont = new Lccont();
        Lcinsured lcinsured = new Lcinsured();
        lcpol.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse("2022-02-22"));
        resEntity.setLcpol(lcpol);
        resEntity.setLccont(lccont);
        resEntity.setLcinsured(lcinsured);
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
        return toJSONString(resEntity);
    }
    @PostMapping("/execute")
    public String execute(@RequestBody ResEntity resEntity) throws Exception {
        System.out.println("resEntity = " + resEntity);
        return droolsService.resuleEntity(resEntity);
    }

    public static String toJSONString(ResEntity resEntity) throws Exception{
        return JSONObject.toJSONString(resEntity,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);
    }
}
