package cn.maxlu.annotation;

import java.util.Arrays;

/**
 * Created by luwei on 2017/6/9.
 */
class Test {
    public static void main(String[] args) {
        Class<Deprecated> clazz = Deprecated.class;

        Class<?>[] interfaces = clazz.getInterfaces();
        System.out.println(Arrays.toString(interfaces));

        Class<? super Deprecated> superclass = clazz.getSuperclass();
        System.out.println(superclass);
    }
}
