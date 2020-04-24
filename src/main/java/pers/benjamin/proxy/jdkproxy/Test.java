package pers.benjamin.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import pers.benjamin.proxy.MyService;
import pers.benjamin.proxy.MyServiceImpl;

public class Test {

    public static void main(String[] args) {
        MyServiceImpl myService = new MyServiceImpl();

        ClassLoader classLoader = myService.getClass().getClassLoader();

        Class<?>[] interfaces = myService.getClass().getInterfaces();

        InvocationHandler myHandler = new MyInvocationHandler(myService);

        MyService proxy = (MyService) Proxy.newProxyInstance(classLoader, interfaces, myHandler);

        proxy.fun();
    }
}
