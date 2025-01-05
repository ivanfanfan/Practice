package com.ivan.c8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Set;

public class C8 {
    static String path = "E:\\code\\Practice\\spring-framework-6.18\\src\\main\\java\\com\\ivan\\c8\\c8.xml";

    public static void main(String[] args) {
        test1();

    }

    private static void test1() {
        GenericApplicationContext context = new GenericApplicationContext();
        new XmlBeanDefinitionReader(context).loadBeanDefinitions("file:"+path);
        context.refresh();
        MovieRecommender movieRecommender = context.getBean("movieRecommender", MovieRecommender.class);
//        System.out.println(((SimpleMovieCatalog) movieRecommender.movieCatalog).num);
        Set<MovieCatalog> movieCatalogs = movieRecommender.movieCatalogs;
        for (MovieCatalog movieCatalog : movieCatalogs) {
            System.out.println(((SimpleMovieCatalog) movieCatalog).num);
        }
    }
}
class MovieRecommender{
//    @Autowired
//    @Qualifier("action")
//    MovieCatalog movieCatalog;

    @Autowired
    @Qualifier("action")
    Set<MovieCatalog> movieCatalogs;
}

interface MovieCatalog {}
class SimpleMovieCatalog implements MovieCatalog {
    int num;
    public SimpleMovieCatalog(int num) {
        this.num = num;
    }
}
