package com.ivan.mvc.m3;

import jakarta.servlet.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import java.io.IOException;


//TODO  不知道应该怎么run

public class MyWebAppInitializer2 extends AbstractDispatcherServletInitializer {

    static final String path = "D:\\ivan-project\\Practice\\spring-framework-6.18\\src\\main\\java\\com\\ivan\\mvc\\m3\\m3.xml";

    @Override
    protected WebApplicationContext createServletApplicationContext() {
        XmlWebApplicationContext webApplicationContext = new XmlWebApplicationContext();
        webApplicationContext.setConfigLocations("file:"+path);
        return webApplicationContext;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[] {
                new HiddenHttpMethodFilter(),
                new CharacterEncodingFilter(),
                new CustomizeFilter()
        };
    }
}
class CustomizeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CustomizeFilter init");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("request : " + request.getParameterMap().keySet());
        System.out.println("customize filter running....");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

