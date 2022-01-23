package com.gu.drools;

import com.gu.drools.Entity.People;
import com.gu.drools.mapper.EntityDateMapper;
import org.junit.jupiter.api.Test;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DroolsApplicationTests {
    @Autowired
    private EntityDateMapper entityDateMapper;
    @Autowired
    private KieSession session;
    @Test
    void contextLoads() {
        EntityDateMapper byEntity = entityDateMapper.getByEntity(1);
        System.out.println("byEntity = " + byEntity);
    }



    @Test
    public void peoplse() {
        People people = new People();
        people.setAge(1);
        people.setName("张三");
        session.insert(people);
        int i = session.fireAllRules();
        session.destroy();
        System.out.println("people = " + people);
    }
}
