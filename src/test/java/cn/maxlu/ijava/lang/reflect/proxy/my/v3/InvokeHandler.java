package cn.maxlu.ijava.lang.reflect.proxy.my.v3;

import java.lang.reflect.Method;

/**
 * Created by luwei on 2017/5/4.
 */
public interface InvokeHandler {

    Object invoke(Method method, Object[] args) throws Exception;
}
