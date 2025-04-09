package com.ivan.mybatis.controller;

import com.ivan.mybatis.entity.Person;
import com.ivan.mybatis.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoMapper baseMapper;

    @PostMapping("/save")
    public String save(@RequestBody Person person){
        baseMapper.insert(person);
        return "success";
    }
    @GetMapping("/{id}")
    public Person get(@PathVariable(name = "id") Long id){
        return baseMapper.selectById(id);
    }
}
