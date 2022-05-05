package com.gu.drools.controller;

import com.gu.drools.config.swagger2.Swagger2;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("test")
@Slf4j
public class testsController {
    @ApiOperation("自定义测试")
    @GetMapping("/test")
    public Swagger2 test1(){
        return new Swagger2();
    }
}
