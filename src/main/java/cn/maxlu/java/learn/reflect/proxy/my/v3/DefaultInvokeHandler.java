package cn.maxlu.java.learn.reflect.proxy.my.v3;

import java.lang.reflect.Method;

/**
 * Created by luwei on 2017/5/4.
 */
public class DefaultInvokeHandler implements InvokeHandler{

    private Object target;

    public DefaultInvokeHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Method method, Object[] args) throws Exception {
        System.out.println("=====exec before=====");
        Object invoke = method.invoke(target, args);
        System.out.println("=====exec after=====");
        return invoke;
    }
}
