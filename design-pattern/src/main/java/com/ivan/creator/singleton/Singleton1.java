package com.ivan.creator.singleton;

public class Singleton1 {

    private Singleton1(){}

    private static final Singleton1 singleton = new Singleton1();

    public Singleton1 getSingleton() {
        return singleton;
    }
}
