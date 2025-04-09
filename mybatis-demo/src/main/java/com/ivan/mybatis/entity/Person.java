package com.ivan.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;

@Data
@TableName(value = "person", autoResultMap = true)
public class Person {
    private Long id;

    private String name;


    private Object addresses;

}
