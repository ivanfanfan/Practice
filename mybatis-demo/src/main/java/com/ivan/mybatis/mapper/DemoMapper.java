package com.ivan.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ivan.mybatis.entity.Person;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DemoMapper extends BaseMapper<Person> {

}
