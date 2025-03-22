package com.ivan.mybatis.controller;

import com.ivan.mybatis.entity.Person;
import com.ivan.mybatis.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @PostMapping("/save")
    public String save(@RequestBody Person person){
        demoService.save(person);
        return "success";
    }
    @GetMapping("/{id}")
    public Person get(@PathVariable(name = "id") Integer id){
        return demoService.getById(id);
    }
}
