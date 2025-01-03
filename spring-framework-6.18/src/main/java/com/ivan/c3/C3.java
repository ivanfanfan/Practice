package com.ivan.c3;

import org.gradle.internal.impldep.org.apache.sshd.client.auth.pubkey.UserAuthPublicKeyIterator;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class C3 {

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    private static void test3()  {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("file:D:\\ivan-project\\Practice\\spring-framework-6.18\\src\\main\\java\\com\\ivan\\c3\\c3.xml");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ExampleBean beanOne = context.getBean("beanOne", ExampleBean.class);
        System.out.println(beanOne);
    }

    private static void test2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("file:D:\\ivan-project\\Practice\\spring-framework-6.18\\src\\main\\java\\com\\ivan\\c3\\c3.xml");
        TheClientBean theClientBean = context.getBean("theClientBean", TheClientBean.class);
        System.out.println(theClientBean.getTargetBean());
    }

    private static void test1() {
        GenericApplicationContext context = new GenericApplicationContext();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions("file:D:\\ivan-project\\Practice\\spring-framework-6.18\\src\\main\\java\\com\\ivan\\c3\\c3.xml");
        context.refresh();
        MyDataSource myDataSource = context.getBean("myDataSource", MyDataSource.class);
        System.out.println(myDataSource);
    }

}

class ExampleBean{}
class ManagerBean{
    public ManagerBean(){
        System.out.println("is depended");
    }
}



class TheTargetBean{}
class TheClientBean{
    TheTargetBean targetBean;

    public TheTargetBean getTargetBean() {
        return targetBean;
    }

    public void setTargetBean(TheTargetBean targetBean) {
        this.targetBean = targetBean;
    }
}

class MyDataSource{
    String url;
    String username;
    String password;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}