package com.gu.drools.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.gu.drools.Vo.ResEntity;
import com.gu.drools.entry.Bom;
import com.gu.drools.entry.RuleDate;
import com.gu.drools.fosunhealth.entity.*;
import com.gu.drools.service.DroolsService;
import com.gu.drools.service.RuleMakeService;
import com.gu.drools.tools.rule.TrunMain;
import org.drools.core.ClassObjectFilter;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("drools")
public class TestController {
    public static final String FUrl = "src/main/resources/";
    @Autowired
    private DroolsService droolsService;
    @Autowired
    private RuleMakeService service;
    @PostMapping("/upload")
    public String test(@RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()){
            File fileUrl = new File(FUrl + "upload/"+file.getOriginalFilename());
            if (!fileUrl.exists()){
                fileUrl.createNewFile();
            }
            Files.write(Paths.get(fileUrl.getAbsolutePath()),file.getBytes());
        }



        return file.toString();
    }
    @GetMapping("/getDrl/{id}")
    public Map getDrl(@PathVariable Integer id) throws IOException {
        Map<String, String> drl = new HashMap<>();
        RuleDate ruleDate = service.toRuleDate(id);
        System.out.println("ruleDate = " + ruleDate);
        if (ruleDate == null){
            drl.put("drl","id不存在");
            return drl;
        }
        System.out.println("ruleDate.getPredefinedList() = " + ruleDate.getPredefinedList());
        drl = TrunMain.TrunDrl(ruleDate);
        newFile(drl);
        return drl;
    }

    private void newFile(Map<String, String> code) throws IOException {
        File file = new File(FUrl + "rules/"+code.get("code")+".drl");
        if (!file.exists()){
            file.createNewFile();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        StringBuilder drl = new StringBuilder();
        drl.append("package rules"+"\r\n");
        drl.append("import com.gu.drools.fosunhealth.entity.*;"+"\r\n");
        drl.append("import com.gu.drools.fosunhealth.util.*;"+"\r\n");
        drl.append("import java.util.*;"+"\r\n");
        drl.append("import java.text.*;"+"\r\n");
        drl.append("import java.lang.*;"+"\r\n");
        drl.append("import com.alibaba.fastjson.*;"+"\r\n");
        drl.append("dialect  \"mvel\""+"\r\n");
        writer.append(drl.toString());
        writer.append(code.get("drl"));
        writer.close();
    }

    @GetMapping("/getEntity")
    public String getEntity() throws Exception {
        ResEntity resEntity = new ResEntity();
        Lccont lccont = new Lccont();
        lccont.getLcinsuredList().add(new Lcinsured());
        lccont.getLcinsuredList().add(new Lcinsured());
        resEntity.setLccont(lccont);

        resEntity.setLccont(lccont);
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
        return toJSONString(resEntity);
    }
    @PostMapping("/execute")
    public String execute(@RequestBody ResEntity resEntity) throws Exception {
        return droolsService.resuleEntity(resEntity);
    }

    public static String toJSONString(ResEntity resEntity) throws Exception{
        return JSONObject.toJSONString(resEntity,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);
    }
}
