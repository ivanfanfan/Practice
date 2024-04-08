package com.ivan.creational.singleton;

public class Singleton4 {
    private Singleton4() {
    }

    /**
     * 内部类， jvm 在加载外部类的时候不会加载内部类 只有在内部类的方法/属性 被调用才会被加载。
     */
    private static class SingletonHolder {
        private static final Singleton4 INSTANCE = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
