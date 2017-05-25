package cn.maxlu.java.learn.reflect.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by max.lu on 2016/1/26.
 */
public class HelloTest {
    public static void main(String[] args) {
        Hello hello = new HelloImpl();
        HelloHandle helloHandle = new HelloHandle(hello);
        Hello proxy = (Hello) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), helloHandle);
        proxy.say();
    }
}
