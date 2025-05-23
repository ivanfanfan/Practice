package com.ivan.character;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CopyLines {
    public static void main(String[] args) throws Exception {
//        test1();
//        test2();
        test3();
//test4();
    }

    private static void test3() throws Exception {
        /**
         * read exclusive txt
         */
        BufferedReader exclusiveInput = new BufferedReader(new FileReader(".\\exclusive.txt"));
        Set<String> exclusiveLines = new HashSet<>();
        String exclusiveLine;
        while ((exclusiveLine = exclusiveInput.readLine()) != null) {
            exclusiveLines.add(exclusiveLine);
        }


        BufferedReader inputStream = new BufferedReader(new FileReader(".\\b.txt"));
        PrintWriter outputStream = new PrintWriter(new FileWriter(".\\c.txt"));
        String line;
        HashMap<String, Integer> map = new LinkedHashMap<>();
        while ((line = inputStream.readLine()) != null) {
            //空格 换行符
            String[] words = line.split("[^a-zA-Z'-]+");
            for (int i = 0; i < words.length; i++) {
                words[i] = words[i].toLowerCase();
                if (map.containsKey(words[i])) {
                    map.put(words[i], map.get(words[i]) + 1);
                } else {
                    map.put(words[i], 1);
                }
            }
        }

        for (String s : map.keySet()) {
            System.out.print(s + " " + map.get(s) + " ");
        }

        List<String> list = map.keySet().stream().sorted((o1, o2) -> map.get(o2).compareTo(map.get(o1))).collect(Collectors.toList());
        for (String s : list) {
            System.out.println(s + " " + map.get(s));
            if (!exclusiveLines.contains(s)) {
                outputStream.println(s);
            }
        }
        inputStream.close();
        exclusiveInput.close();
        outputStream.close();
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

        while ((word = inputStream.readLine()) != null) {
//            outputStream.println(word);
            words.add(word);
        }
        words.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for (int i = 0; i < words.size(); i++) {
            outputStream.println(words.get(i));
        }

        inputStream.close();
        outputStream.close();
    }

    private static void test1() throws Exception {
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("java-io/abc/xanadu.txt"));
            outputStream = new PrintWriter(new FileWriter("java-io/abc/copyLines.txt"));

            String l;
            while ((l = inputStream.readLine()) != null) {
                outputStream.println(l);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    private static void test4() throws Exception {
        BufferedReader inputStream = new BufferedReader(new FileReader("D:\\ivan-project\\Practice\\exclusive.txt"));
        HashSet<String> exclusiveWord = new HashSet<>();
        String word;
        while ((word = inputStream.readLine()) != null) {
            exclusiveWord.add(word);
        }

        inputStream.close();
        PrintWriter outputStream = new PrintWriter(new FileWriter("D:\\ivan-project\\Practice\\exclusive.txt"));
        for (String s : exclusiveWord) {
            if (s.matches("\\b[a-zA-Z]+(?:['-][a-zA-Z]+)*\\b")) {
                outputStream.println(s);
            }
        }
        outputStream.close();

    }


}
