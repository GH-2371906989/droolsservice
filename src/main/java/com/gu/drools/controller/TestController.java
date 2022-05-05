package com.gu.drools.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.gu.drools.File.FileUtil;
import com.gu.drools.Vo.ResEntity;
import com.gu.drools.fosunhealth.entity.*;
import com.gu.drools.service.DroolsService;
import com.gu.drools.service.RuleService;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("drools")
@Slf4j
public class TestController {
    public static final String FUrl = "src/main/resources/";
    @Autowired
    private DroolsService droolsService;
    @Autowired
    private RuleService ruleService;
/*    @PostMapping("/upload")
    public String test(@RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()){
            File fileUrl = new File(FUrl + "upload/"+file.getOriginalFilename());
            if (!fileUrl.exists()){
                fileUrl.createNewFile();
            }
            Files.write(Paths.get(fileUrl.getAbsolutePath()),file.getBytes());
        }



        return file.toString();
    }*/

    public static void main(String[] args) {
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
    @ApiOperation("获取实体")
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
    @ApiOperation("执行")
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
