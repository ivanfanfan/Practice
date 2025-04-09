package com.ivan.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@TableName(value = "person", autoResultMap = true)
public class Person2 {
    @TableId(type = IdType.AUTO)
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String addresses;

    @TableField(exist = false)
    private List<Address> addressList;


    @TableField(exist = false)
    private String addressesStr;

    public List<Address> getAddressList() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return addressList = mapper.readValue(addresses, new TypeReference<List<Address>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public void setAddressList(List<Address> addressList) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            addresses = mapper.writeValueAsString(addressList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        this.addressList = addressList;
    }


    @Data
    public static class Address {
        private int id;
        private String name;
    }
}
