package com.ivan.c12;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

public class C12 {

    static String path = "E:\\code\\Practice\\spring-framework-6.18\\src\\main\\java\\com\\ivan\\c12\\c12.xml";

    public static void main(String[] args) {
        test1();

    }

    private static void test1() {
        MessageSource resources =
                new ClassPathXmlApplicationContext("file:" + path);
        String message = resources.getMessage("message", null, "Default", Locale.ENGLISH);
        System.out.println(message);
    }
}
