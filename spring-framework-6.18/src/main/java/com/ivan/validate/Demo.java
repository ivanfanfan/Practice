package com.ivan.validate;

public class Demo {
    public static void main(String[] args) {
        boolean assignableFrom = Integer.class.isAssignableFrom(String.class);
        System.out.println(assignableFrom);
        System.out.println(Student.class.isAssignableFrom(Student.class));
        System.out.println(Student.class.isAssignableFrom(Person.class));
        System.out.println(Person.class.isAssignableFrom(Student.class));

    }

    static class Person {
        private String name;
    }

    static class Student extends Person {
        private Integer age;
    }


}
