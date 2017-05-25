package cn.maxlu.designpattern.proxy;

import java.lang.reflect.Proxy;

public class MyProxyFactory {
    public static Object getProxy(Object target) {
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        myInvocationHandler.setTarget(target);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), myInvocationHandler);
    }
}
