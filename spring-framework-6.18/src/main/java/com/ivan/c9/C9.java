package com.ivan.c9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

public class C9 {

    public static void main(String[] args) {
//        test1();
        test2();
    }

    private static void test2() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        context.register(Component1.class);
//        context.register(Dependency1.class);
        context.refresh();
        Component1 bean = context.getBean(Component1.class);
        System.out.println(bean.dependency1);
    }


    private static void test1() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Component1.class, Dependency1.class);
        Component1 bean = context.getBean(Component1.class);
        System.out.println(bean.dependency1);
    }

}

@Component
@ComponentScan(basePackages = {"com.ivan.c9"})
class Component1 {
    @Autowired
    Dependency1 dependency1;
}
@Component
class Dependency1 {}
