package com.ivan.structual.proxy.dynamic;

public class Client {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        ISellTicket proxy = proxyFactory.getProxy();
        proxy.sell();
    }
}
