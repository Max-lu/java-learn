package cn.maxlu.ijava.lang.reflect.proxy.my.v2;

import cn.maxlu.ijava.lang.reflect.proxy.my.IService;

/**
 * Created by luwei on 2017/5/3.
 */
public class Proxy_v2Test {
    public static void main(String[] args) throws Exception {

        IService proxy = (IService) Proxy_v2.newProxyInstance();
        if (proxy != null) {
            proxy.print();
        }
    }

}
