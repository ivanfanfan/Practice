package com.ivan.creational.builder;

public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone.Builder()
                .cpu("cup...")
                .memory("内存")
                .price("222")
                .build();
        System.out.println(phone);
    }
}
