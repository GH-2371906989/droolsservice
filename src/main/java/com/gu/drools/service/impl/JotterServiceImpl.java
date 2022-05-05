package com.gu.drools.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gu.drools.mapper.JotterMapper;
import com.gu.drools.mapper.RuleMapper;
import com.gu.drools.pojo.Jotter;
import com.gu.drools.pojo.Rule;
import com.gu.drools.service.JotterService;
import com.gu.drools.service.RuleService;
import org.springframework.stereotype.Service;

@Service
public class JotterServiceImpl extends ServiceImpl<JotterMapper, Jotter> implements JotterService {

}
