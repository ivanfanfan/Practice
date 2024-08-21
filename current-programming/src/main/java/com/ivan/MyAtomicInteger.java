package com.ivan;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class MyAtomicInteger {

    private static Field unsafe;

    static {
        try {

            unsafe = Unsafe.class.getDeclaredField("theUnsafe");
            unsafe.setAccessible(true);

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}
