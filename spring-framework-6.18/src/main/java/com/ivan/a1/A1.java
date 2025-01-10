package com.ivan.a1;

import com.ivan.a1.factory.AccountService;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.Resource;

public class A1 {
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
        test6();
    }


    //instantiation by using an instance factory method
    private static void test6() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("instance-factory-method.xml");
        ClientService clientService = context.getBean("clientService", ClientService.class);
        System.out.println(clientService);
        DefaultServiceLocator serviceLocator = context.getBean("serviceLocator", DefaultServiceLocator.class);
//        ClientService clientServiceInstance = serviceLocator.createClientServiceInstance();
//        System.out.println(clientServiceInstance);

        AccountService accountService = context.getBean("accountService", AccountService.class);
        System.out.println(accountService);
        Object bean = context.getBean("clientServiceBean");
        System.out.println(bean);


    }


    // instantiation by using static factory method;
    private static void test5() {
        GenericApplicationContext context
                = new GenericApplicationContext();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions("factory-method.xml");
        context.refresh();
//  这里的问题是 工厂方法对象返回的是产品类型。BeanNotOfRequiredTypeException
//        ClientService clientService = context.getBean("clientService", ClientService.class);
//        System.out.println(clientService);

        Person person = (Person) context.getBean("clientService");
        System.out.println(person);
//        System.out.println(clientService);


    }

    // alias for bean
    private static void test4() {
        GenericApplicationContext context = new GenericApplicationContext();
        new XmlBeanDefinitionReader(context).
                loadBeanDefinitions("beans.xml", "alias.xml", "person.xml");
        context.refresh();
        Person person = context.getBean("person1", Person.class);
        System.out.println(person);
    }


    private static void test3() {
        GenericApplicationContext context =
                new GenericApplicationContext();
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        if (beanFactory instanceof DefaultListableBeanFactory factory) {

            factory.registerSingleton("person", new Person());
//            factory.registerBeanDefinition();
        }
        //
        context.refresh();
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
    }

    private static void test2() {
        GenericApplicationContext context
                = new GenericApplicationContext();
        new XmlBeanDefinitionReader(context)
                .loadBeanDefinitions("beans.xml", "person.xml");
        context.refresh();
        Person person = context.getBean("person", Person.class);
        System.out.println(person);

    }

    private static void test1() {
        //"beans.xml","person.xml"
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml", "person.xml");

        Person person = context.getBean("person", Person.class);
        System.out.println(person);
    }


}

class ClientService {
    public static Person createInstance() {
        return new Person();
    }
}

class Person {
}

class DefaultServiceLocator {
    public static ClientService clientService = new ClientService();

    public static AccountService accountService = new AccountService();

    public ClientService createClientServiceInstance() {
        return clientService;
    }

    public AccountService createAccountServiceInstance() {
        return accountService;
    }


}