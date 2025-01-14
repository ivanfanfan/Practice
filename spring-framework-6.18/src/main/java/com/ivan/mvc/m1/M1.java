package com.ivan.mvc.m1;

import jakarta.servlet.Registration;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.apache.catalina.core.ApplicationContext;
import org.apache.catalina.core.ApplicationContextFacade;
import org.apache.catalina.core.StandardContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class M1 {
    public static void main(String[] args) throws ServletException {
        //这里传什么进去
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setServletContext(new ApplicationContext(new StandardContext()));
        ServletContext servletContext = context.getServletContext();
        MyWebAppInitializer myWebAppInitializer = new MyWebAppInitializer();
        myWebAppInitializer.onStartup(servletContext);
    }
}

class MyWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//        context.register(AppConfif.class);

        // create and register the dispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/app/*");
    }
}
class MyWebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) {
        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext =
                new AnnotationConfigWebApplicationContext();
//        rootContext. register(AppConfig. class);

        // Manage the lifecycle of the root application context
//        container.addListener(new ContextLoaderListener(rootContext));

        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherContext =
                new AnnotationConfigWebApplicationContext();
//        DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherContext);
//        dispatcherContext.register(dispatcherServlet);

        // Register and map the dispatcher servlet
        ServletRegistration. Dynamic dispatcher =
                container. addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
        dispatcher. setLoadOnStartup(1);
        dispatcher. addMapping("/");
    }

}