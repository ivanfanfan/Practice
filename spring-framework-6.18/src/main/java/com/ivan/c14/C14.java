package com.ivan.c14;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.stereotype.Component;

import java.io.IOException;

public class C14 {
    public static void main(String[] args) throws IOException {
        test1();
    }

    private static void test1() throws IOException {
        GenericApplicationContext context = new GenericApplicationContext();
//        context.registerBean(MyBean.class);
        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(context);
//        StandardEnvironment standardEnvironment = new StandardEnvironment();
//
//        ResourcePropertySource resourcePropertySource = new ResourcePropertySource("classpath:config/template.properties");
//        MutablePropertySources propertySources = standardEnvironment.getPropertySources();
//
//        propertySources.addLast(resourcePropertySource);
//        context.setEnvironment(standardEnvironment);
        reader.register(MyBean.class);
        context.refresh();
        MyBean bean = context.getBean(MyBean.class);
        System.out.println(bean.template);
    }
}

@Component
@PropertySource("classpath:config/template.properties")
class MyBean {

    final Resource template;

    public MyBean(@Value("${template.path}") Resource template) {
        this.template = template;
    }
}
