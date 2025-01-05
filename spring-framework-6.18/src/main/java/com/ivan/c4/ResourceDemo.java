package com.ivan.c4;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ResourceDemo {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:config/c4.xml");
        System.out.println(context.getBean("resourcePath"));

    }
}

class ResourcePath{}