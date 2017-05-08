package cn.maxlu;

import java.lang.reflect.Method;

/**
 * Created by lw on 2016/7/18.
 */

public class Test {

    private static ThreadLocal<String> v1 = new ThreadLocal<>();
    private static String v2 = null;

    public static void main(String[] args) {
        Method[] methods = Runnable.class.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

    }
}
