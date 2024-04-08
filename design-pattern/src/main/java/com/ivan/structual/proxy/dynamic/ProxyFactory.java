package com.ivan.structual.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    private TrainStation trainStation = new TrainStation();

    public ISellTicket getProxy(){
        ISellTicket proxyInstance = (ISellTicket) Proxy.newProxyInstance(
                trainStation.getClass().getClassLoader(),
                trainStation.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("proxy-----------------");
                        Object obj = method.invoke(trainStation, args);
                        return obj;
                    }
                }
        );
        return proxyInstance;
    }
}
