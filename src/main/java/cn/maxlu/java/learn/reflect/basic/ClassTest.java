package cn.maxlu.java.learn.reflect.basic;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Created by luwei on 2017/6/8.
 */
@SuppressWarnings({"unchecked", "unused"})
@Deprecated
public class ClassTest implements Serializable {

    public int a;

    public static void main(String[] args) throws ClassNotFoundException {
        Class<ClassTest> clazz = ClassTest.class;
        @SuppressWarnings("unchecked")
        Class<ClassTest> clazz2 = (Class<ClassTest>) Class.forName("cn.maxlu.java.learn.reflect.basic.ClassTest");

        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());

        System.out.println(Modifier.toString(clazz.getModifiers()));

        System.out.println(clazz.getPackage());

        System.out.println(clazz.getSuperclass());

        System.out.println(Arrays.toString(clazz.getInterfaces()));

        System.out.println(Arrays.toString(clazz.getConstructors()));

        System.out.println(Arrays.toString(clazz.getMethods()));

        System.out.println(Arrays.toString(clazz.getFields()));

        System.out.println(Arrays.toString(clazz.getAnnotations()));
    }
}
