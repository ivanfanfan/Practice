package com.ivan.mvc.m2;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import java.io.IOException;
import java.util.Map;

public class M2 {
    public static void main(String[] args) throws IOException {
//        test1();
        test2();
    }

    private static void test2() {

        AnnotationConfigServletWebServerApplicationContext context =
                new AnnotationConfigServletWebServerApplicationContext(WebConfig.class);

    }


    //TODO  can't start with tomcat
    private static void test1() throws IOException {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.preInstantiateSingletons();

        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(beanFactory);
        reader.register(WebConfig.class);

        AnnotationConfigUtils.registerAnnotationConfigProcessors(beanFactory);

        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        beanFactoryPostProcessorMap.forEach((k, v) -> {
            v.postProcessBeanFactory(beanFactory);
        });
//        System.in.read();
        for (String singletonName : beanFactory.getSingletonNames()) {
            System.out.println(singletonName);
            if(singletonName.contains("tomcat") || singletonName.contains("web")){
                System.out.println(singletonName);
            }
        }
        DispatcherServlet bean = beanFactory.getBean(DispatcherServlet.class);
        System.out.println(bean);

//        TomcatWebServer bean = beanFactory.getBean(TomcatWebServer.class);
//        bean.start();
//        AnnotationConfigServletWebServerApplicationContext

    }
}

@Configuration
@ComponentScan(basePackages = "com.ivan.mvc.m2")
class WebConfig {

    @Bean
    public TomcatServletWebServerFactory tomcatServletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }
    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }
    @Bean
    public DispatcherServletRegistrationBean dispatcherServletRegistrationBean() {
        return new DispatcherServletRegistrationBean(dispatcherServlet(), "/");
    }

    @Bean("/hello")
    public Controller controller() {
        return new Controller() {
            @Override
            public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
                response.getWriter().write("hello");
                return null;
            }
        };
    }

}
