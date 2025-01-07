package com.ivan.c10;

import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

import java.util.Map;
import java.util.Properties;

public class C10 {

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    private static void test3() {
        Properties properties = System.getProperties();
        Map<String, String> map = System.getenv();
//        properties.values().forEach(System.out::println);
        properties.keySet().forEach(item ->
        {
            System.out.print(item + "-----");
            System.out.print(properties.get(item));
            System.out.println();
        });
        map.values().forEach(System.out::println);

    }

    private static void test2() {
        GenericApplicationContext context
                = new GenericApplicationContext();
        Environment environment = context.getEnvironment();
        boolean b = environment.containsProperty("my-property");
        System.out.println(b);

    }

    private static void test1() {
        GenericApplicationContext context = new GenericApplicationContext();
        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(context);
        reader.register(Config2.class);
        context.refresh();
        Bean1 bean = context.getBean(Bean1.class);
        System.out.println(bean);
    }
}

class Bean1{}
class Bean2{}
@Configuration
class Config1{
    @Bean
    public Bean1 bean1(){
        return new Bean1();
    }
}
@Configuration
@Import(value = {com.ivan.c10.Config1.class})
class Config2{
    @Bean
    public Bean2 bean2(){
        return new Bean2();
    }
}