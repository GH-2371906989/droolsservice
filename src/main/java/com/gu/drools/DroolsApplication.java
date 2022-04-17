package com.gu.drools;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.gu.drools.mapper")
public class DroolsApplication {

    public static void main(String[] args) {

        SpringApplication.run(DroolsApplication.class, args);
    }

}
