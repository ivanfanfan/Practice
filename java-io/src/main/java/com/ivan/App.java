package com.ivan;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        method1();
        System.out.println( "Hello World!" );
    }
    public static void method1(){
        System.out.println("method1 run");
        method2();
        System.out.println("method1 done");

    }

    private static void method2() {
        System.out.println("method2 run");
        method3();
        System.out.println("method2 done");
    }

    private static void method3() {
        System.out.println("method3 run");
        method4();
        System.out.println("method3 done");
    }

    private static void method4() {
        int i = 1 / 0;
    }
}
