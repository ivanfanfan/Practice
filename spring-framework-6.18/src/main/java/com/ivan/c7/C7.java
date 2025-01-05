package com.ivan.c7;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.*;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;

public class C7 {
    private static final Log log = LogFactory.getLog(C7.class);

    static String path = "E:\\code\\Practice\\spring-framework-6.18\\src\\main\\java\\com\\ivan\\c7\\c7.xml";

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    private static void test3() {
//        AnnotationConfigApplicationContext context
//                = new AnnotationConfigApplicationContext(MovieConfiguration.class);
        GenericApplicationContext context = new GenericApplicationContext();
        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(context);
//        XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(context);
//        xmlReader.loadBeanDefinitions("file:"+path);
        reader.register(MovieConfiguration.class);
        context.refresh();
        MovieRecommender movieCatalog = context.getBean("movieRecommender", MovieRecommender.class);
        System.out.println(((SimpleMovieCatalog) movieCatalog.movieCatalog).num);

    }

    private static void test2() {
        GenericApplicationContext context = new GenericApplicationContext();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions("file:"+path);
        context.refresh();
        MovieRecommender movieRecommender = context.getBean("movieRecommender", MovieRecommender.class);
        System.out.println(((SimpleMovieCatalog) movieRecommender.movieCatalog).num);
    }

    /**
     * org.springframework.context.annotation.internalConfigurationAnnotationProcessor
     * org.springframework.context.annotation.internalAutowiredAnnotationProcessor
     * org.springframework.context.event.internalEventListenerProcessor
     * org.springframework.context.event.internalEventListenerFactory
     * ----------------
     * --- singletonName: environment
     * --- singletonName: systemProperties
     * --- singletonName: systemEnvironment
     * --- singletonName: applicationStartup
     * --- singletonName: org.springframework.context.annotation.internalConfigurationAnnotationProcessor
     * --- singletonName: org.springframework.context.event.internalEventListenerProcessor
     * --- singletonName: org.springframework.context.event.internalEventListenerFactory
     * --- singletonName: org.springframework.context.annotation.internalAutowiredAnnotationProcessor
     * --- singletonName: messageSource
     * --- singletonName: applicationEventMulticaster
     * --- singletonName: lifecycleProcessor
     */


    private static void test1() {
        GenericApplicationContext context = new GenericApplicationContext();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions("file:"+ path    );
        context.refresh();
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("----------------");
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        String[] singletonNames = beanFactory.getSingletonNames();
        for (String singletonName : singletonNames) {
            System.out.println("--- singletonName: " + singletonName);
        }
        Map<String, BeanFactoryPostProcessor> beansOfType =
                beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        beansOfType.values().forEach(System.out::println);
        System.out.println("==========================");
        beansOfType.keySet().forEach(System.out::println);
        System.out.println("beanPostProcessor ---------------------");
        Map<String, BeanPostProcessor> beanPostProcesses =
                beanFactory.getBeansOfType(BeanPostProcessor.class);
        beanPostProcesses.values().forEach(System.out::println);
        System.out.println("==========================");
        beanPostProcesses.keySet().forEach(System.out::println);
    }
}
@Configuration
@ComponentScan(basePackages = {"com.ivan.c7"})
class MovieConfiguration{
    @Bean
    @Primary
    public MovieCatalog firstMovieCatalog(){
        return new SimpleMovieCatalog(1);
    }
    @Bean
    public MovieCatalog secondMovieCatalog(){
        return new SimpleMovieCatalog(2);
    }
}
class SimpleMovieCatalog implements MovieCatalog {
    int num;
    public SimpleMovieCatalog(int num) {
        this.num = num;
    }
}
interface MovieCatalog {}
@Component
class MovieRecommender{
    @Autowired
    MovieCatalog movieCatalog;
}

