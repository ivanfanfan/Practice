package com.ivan.creational.singleton;

public class Singleton3 {

    private Singleton3(){}

    private static Singleton3 singleton3;
    static {
        singleton3 = new Singleton3();
    }

    public static Singleton3 getSingleton(){
        return singleton3;
    }
}
