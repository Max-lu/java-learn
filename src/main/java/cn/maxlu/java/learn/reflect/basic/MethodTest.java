package cn.maxlu.java.learn.reflect.basic;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by luwei on 2017/6/8.
 */
public class MethodTest {

    public static void setStatic(String name) {

    }

    public void set(String name) {

    }

    public String get() {
        return "hello";
    }

    public static void main(String[] args) throws Exception {
        Class<MethodTest> clazz = MethodTest.class;

        Method[] methods = clazz.getMethods();
        System.out.println(Arrays.toString(methods));

        Method getMethod = clazz.getMethod("get");
        Method setMethod = clazz.getMethod("set", String.class);
        System.out.println(getMethod);
        System.out.println(setMethod);

        Class<?>[] parameterTypes = setMethod.getParameterTypes();
        System.out.println(Arrays.toString(parameterTypes));

        Class<?> returnType = setMethod.getReturnType();
        System.out.println(returnType);

        Method setStaticMethod = clazz.getMethod("setStatic", String.class);
        //调用静态方法，第一个参数传递null即可
        Object result1 = setStaticMethod.invoke(null, "hello");
        System.out.println(result1);

        MethodTest methodTest = new MethodTest();
        Object result2 = setMethod.invoke(methodTest, "hello");
        System.out.println(result2);

        Object result3 = getMethod.invoke(methodTest);
        System.out.println(result3);
    }
}
