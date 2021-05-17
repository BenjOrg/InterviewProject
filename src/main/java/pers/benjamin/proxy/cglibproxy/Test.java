package pers.benjamin.proxy.cglibproxy;

import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;
import net.sf.cglib.core.NamingPolicy;
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


        BeanGenerator beanGenerator = new BeanGenerator();
        beanGenerator.addProperty("tableName", String.class);
        Object newObj = beanGenerator.create();


        BeanMap beanMap = BeanMap.create(newObj);
        beanMap.put("tableName", "table_test");

        System.out.println("");
    }
}
