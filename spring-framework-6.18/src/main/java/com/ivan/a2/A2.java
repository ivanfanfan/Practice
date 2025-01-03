package com.ivan.a2;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;


public class A2 {
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
        test4();
    }

    private static void test4() {

    }

    // setter 注入 再构造之后 属性property 自动注入
    private static void test3() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("file:D:\\ivan-project\\Practice\\spring-framework-6.18\\src\\main\\java\\com\\ivan\\a2\\a2.xml");
        SimpleMovieLister simpleMovieLister = context.getBean("simpleMovieLister", SimpleMovieLister.class);
        System.out.println(simpleMovieLister.movieFinder);
    }

    private static void test2() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("file:D:\\ivan-project\\Practice\\spring-framework-6.18\\src\\main\\java\\com\\ivan\\a2\\a2.xml");
        ExampleBean exampleBean = context.getBean("exampleBean", ExampleBean.class);
        System.out.println(exampleBean.year);
        System.out.println(exampleBean.ultimateAnswer);
    }

    //constructor injection
    private static void test1() {
        GenericApplicationContext context = new GenericApplicationContext();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        int i = reader.loadBeanDefinitions("file:D:\\ivan-project\\Practice\\spring-framework-6.18\\src\\main\\java\\com\\ivan\\a2\\a2.xml");
        context.refresh();
        BeanOne beanOne = context.getBean("beanOne", BeanOne.class);
        System.out.println(beanOne.beanThree);
        System.out.println(beanOne.beanTwo);
        System.out.println(beanOne);

    }
}
class ExampleBean{

    final int year;
    final String ultimateAnswer;
    public ExampleBean(int year, String ultimateAnswer) {
        this.year = year;
        this.ultimateAnswer = ultimateAnswer;
    }
}
class BeanOne{
    BeanTwo beanTwo;
    BeanThree beanThree;
    public BeanOne(BeanTwo beanTwo, BeanThree beanThree) {
        this.beanTwo = beanTwo;
        this.beanThree = beanThree;
    }
}
class BeanTwo{}
class BeanThree{}
class SimpleMovieLister {
    MovieFinder movieFinder;

    public void setMovieFinder(MovieFinder movieFinder) {
        System.out.println("run set");
        this.movieFinder = movieFinder;
    }

}
class MovieFinder{

}