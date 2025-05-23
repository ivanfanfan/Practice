package com.ivan.creational.singleton;

public class Singleton2 {
    private Singleton2(){}

    private static volatile Singleton2 singleton;

    public Singleton2 getSingleton() {
        if(singleton == null) {
            synchronized (Singleton2.class){
                if(singleton == null) {
                    singleton = new Singleton2();
                }
            }

        }
        return singleton;
    }
}
