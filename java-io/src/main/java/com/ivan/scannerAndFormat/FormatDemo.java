package com.ivan.scannerAndFormat;

import java.sql.SQLOutput;

public class FormatDemo {
    public static void main(String[] args) {
        int i = 2;
        double r = Math.sqrt(i);
        System.out.format("The square root of %d is %f. %n", i, r);
        int a = 11;
        // hexadecimal
        System.out.format("The 17 to hex is %x. %n",a);
        //custom format
        customFormat();

    }
    public static void customFormat() {

        System.out.format("%f, %1$+020.10f %n", Math.PI);
        //3.141593, +00000003.1415926536

    }


}
