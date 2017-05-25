package cn.maxlu.java.learn.reflect.proxy.my.v3;


import cn.maxlu.java.learn.reflect.proxy.my.DefaultService2Impl;
import cn.maxlu.java.learn.reflect.proxy.my.IService2;

import java.util.HashMap;

/**
 * Created by luwei on 2017/5/3.
 */
public class Proxy_v3Test {
    public static void main(String[] args) throws Exception {

        DefaultService2Impl defaultService2 = new DefaultService2Impl();
        IService2 proxy = Proxy_v3.newProxyInstance(IService2.class, new DefaultInvokeHandler(defaultService2));
        if (proxy != null) {
            String arg1 = "hello world";
            HashMap<String, Object> arg2 = new HashMap<>();
            arg2.put("name", "max");
            arg2.put("age", "20");
            int[] arg3 = {1, 2, 3};
            proxy.print(arg1, arg2, arg3, "a", "b");
        }
    }

}
