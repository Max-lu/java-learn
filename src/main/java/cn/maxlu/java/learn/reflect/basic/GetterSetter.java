package cn.maxlu.java.learn.reflect.basic;

import java.beans.Introspector;
import java.lang.reflect.Method;

/**
 * Created by luwei on 2017/6/8.
 */
public class GetterSetter {


    /**
     * @see Introspector
     * @param args
     */
    public static void main(String[] args) {
        Class<GetterSetter> clazz = GetterSetter.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (isGetter(method)) {
                System.out.println(method.getName());
            } else if (isSetter(method)) {
                System.err.println(method.getName());
            }

        }
    }

    private static boolean isSetter(Method method) {
        if (!method.getName().startsWith("set")) {
            return false;
        }
        if (method.getParameterCount() != 1) {
            return false;
        }
        return true;
    }

    private static boolean isGetter(Method method) {
        if (!method.getName().startsWith("get") && (method.getReturnType().equals(boolean.class) && !method.getName().startsWith("is"))) {
            return false;
        }
        if (method.getParameterCount() != 0) {
            return false;
        }
        if (method.getReturnType().equals(Void.class)) {
            return false;
        }
        return true;
    }

    public int a;

    public String b;

    private boolean c;

    private Boolean d;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public boolean isC() {
        return c;
    }

    public void setC(boolean c) {
        this.c = c;
    }

    public Boolean getD() {
        return d;
    }

    public void setD(Boolean d) {
        this.d = d;
    }
}
