package cn.maxlu.java.learn.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by max.lu on 2016/1/26.
 */
public class HelloHandle implements InvocationHandler {

    private Object object;

    public HelloHandle(Object o) {
        super();
        this.object = o;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("--before--");
        Object result = method.invoke(object, args);
        System.out.println("--after--");
        return result;
    }
}
