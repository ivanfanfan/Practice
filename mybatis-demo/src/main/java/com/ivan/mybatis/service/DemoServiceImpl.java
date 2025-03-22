package com.ivan.mybatis.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ivan.mybatis.entity.Person;
import com.ivan.mybatis.mapper.DemoMapper;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl extends ServiceImpl<DemoMapper, Person> implements DemoService {

}
