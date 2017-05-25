package cn.maxlu.java.learn.reflect.proxy.my.v1;

import cn.maxlu.java.learn.reflect.proxy.my.DefaultServiceImpl;
import cn.maxlu.java.learn.reflect.proxy.my.IService;


/**
 * Created by luwei on 2017/5/3.
 */
public class Proxy_v1Test {
    public static void main(String[] args) {
        IService service = new DefaultServiceImpl();
        Proxy_v1 proxy = new Proxy_v1(service);
        proxy.print();
    }
}
