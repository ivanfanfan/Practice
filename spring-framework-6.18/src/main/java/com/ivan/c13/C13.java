package com.ivan.c13;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;

import java.util.List;

public class C13 {
    static final String path = "D:\\ivan-project\\Practice\\spring-framework-6.18\\src\\main\\java\\com\\ivan\\c13\\c13.xml";
    static final String propertiesPath = "D:\\ivan-project\\Practice\\spring-framework-6.18\\src\\main\\java\\com\\ivan\\c13\\c13.properties";

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    private static void test3() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(beanFactory);
        reader.register(Config.class);
        beanFactory.addBeanPostProcessor(new AutowiredAnnotationBeanPostProcessor());
        beanFactory.addBeanPostProcessor(new CommonAnnotationBeanPostProcessor());
        //添加处理Configuration注解的处理器
        //TODO 添加Configuration注解的处理器
        List<BeanPostProcessor> beanPostProcessors = beanFactory.getBeanPostProcessors();

        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            System.out.println("beanPostProcessor:" + beanPostProcessor);
        }
        Bean1 bean = beanFactory.getBean(Bean1.class);
        System.out.println(bean);
    }

    private static void test2() {
        DefaultListableBeanFactory defaultListableBeanFactory =
                new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader =
                new XmlBeanDefinitionReader(defaultListableBeanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions(
                new FileSystemResource(path)
        );
        PropertySourcesPlaceholderConfigurer cfg =
                new PropertySourcesPlaceholderConfigurer();
        cfg.setLocation(new FileSystemResource(propertiesPath));
        cfg.postProcessBeanFactory(defaultListableBeanFactory);
        Bean1 bean = defaultListableBeanFactory.getBean(Bean1.class);
        System.out.println(bean);
        System.out.println(bean.home);
    }

    private static void test1() {
        DefaultListableBeanFactory defaultListableBeanFactory =
                new DefaultListableBeanFactory();
        int beanPostProcessorCount = defaultListableBeanFactory.getBeanPostProcessorCount();
        System.out.println(beanPostProcessorCount);
        defaultListableBeanFactory.addBeanPostProcessor(new AutowiredAnnotationBeanPostProcessor());
    }
}

@Configuration
class Config{
    @Bean
    public Bean1 bean1(){
        return new Bean1();
    }
}
class Bean1 {
    @Value("${abc}")
    String home;

    public void setHome(String home) {
        this.home = home;
    }
}
class Bean2 {}