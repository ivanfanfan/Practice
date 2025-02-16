package com.ivan.character;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CopyLines {
    public static void main(String[] args) throws Exception {
//        test1();
        test2();
    }

    private static void test2() throws Exception {
        BufferedReader inputStream = new BufferedReader(
                new FileReader("E:\\code\\Practice\\spring security.txt")
        );

        PrintWriter outputStream = new PrintWriter(
                new FileWriter("E:\\code\\Practice\\spring security ordered.txt")
        );
        String word;
        List<String> words = new ArrayList<>();
//        words.add(word);

        while((word = inputStream.readLine()) != null) {
//            outputStream.println(word);
            words.add(word);
        }
        words.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for (int i  = 0; i < words.size(); i++) {
            outputStream.println(words.get(i));
        }

        inputStream.close();
        outputStream.close();
    }

    private static void test1() throws Exception {
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try{
            inputStream = new BufferedReader(new FileReader("java-io/abc/xanadu.txt"));
            outputStream = new PrintWriter(new FileWriter("java-io/abc/copyLines.txt"));

            String l;
            while ((l = inputStream.readLine()) != null) {
                outputStream.println(l);
            }
        }finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }

    }




}
