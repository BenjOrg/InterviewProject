package pers.benjamin.proxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import pers.benjamin.proxy.MyService;
import pers.benjamin.proxy.MyServiceImpl;

public class Test {

    public static void main(String[] args) {
        MyInterceptor myInterceptor = new MyInterceptor();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MyServiceImpl.class);
        enhancer.setCallback(myInterceptor);

        MyService proxy = (MyService) enhancer.create();

        proxy.fun();
    }
}
