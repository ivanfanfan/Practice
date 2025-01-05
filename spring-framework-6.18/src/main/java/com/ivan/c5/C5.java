package com.ivan.c5;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

public class C5 {

    static String path = "E:\\code\\Practice\\spring-framework-6.18\\src\\main\\java\\com\\ivan\\c5\\c5.xml";

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        GenericApplicationContext context = new GenericApplicationContext();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(context);
        xmlBeanDefinitionReader.loadBeanDefinitions("file:" + path);
        context.refresh();
        InheritsWithDifferentClass inheritsWithDifferentClass = context.getBean("inheritsWithDifferentClass", InheritsWithDifferentClass.class);
        System.out.println(inheritsWithDifferentClass.name);

    }
}

class DefaultInitOrDestroy {
    AnotherExampleBean anotherExampleBean;
    public void initialization() {
        System.out.println("this method is default initial method");
    }

    public void setAnotherExampleBean(AnotherExampleBean anotherExampleBean) {
        System.out.println("setAnotherExampleBean..");
        this.anotherExampleBean = anotherExampleBean;
    }
}

class AnotherExampleBean implements InitializingBean {
    public AnotherExampleBean() {
        System.out.println("AnotherExampleBean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    public void init() {
        System.out.println("another init");
    }
}

class ExampleBean {
    public ExampleBean() {
        System.out.println("construct ExampleBean");
    }

    public void init() {
        System.out.println("init method");
    }
}
abstract class InheritedTestBean {
    String name;
    Integer age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
class InheritsWithDifferentClass {
    String name;

    public void setName(String name) {
        this.name = name;
    }
}
class InstantiationTracingBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + "  postProcessBeforeInitialization..");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Bean '" + beanName + "'created: " + bean.toString());
        return bean;
    }

}