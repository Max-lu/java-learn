package cn.maxlu.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by luwei on 2017/4/13.
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> aClass = myClassLoader.loadClass("cn.maxlu.classloader.ClassToBeLoad");
        Object instance = aClass.newInstance();
        Method sayMethod = aClass.getMethod("say");
        sayMethod.invoke(instance);

        System.out.println(instance.getClass());
        System.out.println(instance.getClass().getClassLoader());
    }
}
