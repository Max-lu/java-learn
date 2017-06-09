package cn.maxlu.java.learn.reflect.basic;

import java.lang.reflect.Array;

/**
 * Created by luwei on 2017/6/8.
 */
public class ArrayTest {
    public static void main(String[] args) throws Exception {
        int[] array = (int[]) Array.newInstance(int.class, 3);

        Array.set(array, 0, 0);
        Array.set(array, 1, 1);
        Array.set(array, 2, 2);

        Object o1 = Array.get(array, 0);
        Object o2 = Array.get(array, 1);
        Object o3 = Array.get(array, 2);

        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o3);

        Class<String[]> aClass = String[].class;
        Class<int[]> aClass1 = int[].class;

        System.out.println(aClass);
        System.out.println(aClass1);

        Class<?> aClass2 = Class.forName("[I");
        Class<?> aClass3 = Class.forName("[Ljava.lang.String;");

        System.out.println(aClass2);
        System.out.println(aClass3);

        Class aClass4 = getClass("int");
        Class<?> aClass5 = Array.newInstance(aClass4, 3).getClass();
        System.out.println(aClass5.isArray());

        Class<?> componentType = aClass5.getComponentType();
        System.out.println(componentType);
    }

    public static Class getClass(String className) throws Exception {
        if ("int".equals(className)) return int.class;
        if ("long".equals(className)) return long.class;
        //...
        return Class.forName(className);
    }

}
