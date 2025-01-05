package com.ivan.c6;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

import javax.sql.DataSource;

public class C6 {
    static String path = "E:\\code\\Practice\\spring-framework-6.18\\src\\main\\java\\com\\ivan\\c6\\c6.xml";

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        GenericApplicationContext context = new GenericApplicationContext();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        int i = reader.loadBeanDefinitions("file:" + path);
        context.refresh();
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        beanFactory.getSingletonCount();
        String[] singletonNames = beanFactory.getSingletonNames();
        for (String name : singletonNames) {
            System.out.println(name);
        }
        BasicDataSource datasource = beanFactory.getBean("dataSource", BasicDataSource.class);
        System.out.println(datasource.driverClassName);
        System.out.println(datasource.username);
    }
}
class BasicDataSource {
     String driverClassName;
     String url;
     String username;
     String password;

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
