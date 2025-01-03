package com.ivan.a1.factory;

import com.ivan.pojo.Person;

public class ClientService {
    public static Person createInstance() {
        return new Person();
    }
}
