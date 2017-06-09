package cn.maxlu.java.learn.reflect.basic;

import java.lang.reflect.Constructor;
import java.util.Arrays;

/**
 * Created by luwei on 2017/6/8.
 */
public class ConstructorTest {

    public ConstructorTest() {
    }

    public ConstructorTest(int a) {
        System.out.println("int");
    }

    public ConstructorTest(Integer a) {
        System.out.println("Integer");
    }

    public static void main(String[] args) throws Exception {
        Class<ConstructorTest> clazz = ConstructorTest.class;
        Constructor<?>[] constructors = clazz.getConstructors();
        System.out.println(Arrays.toString(constructors));

        Constructor<ConstructorTest> constructor1 = clazz.getConstructor();
        Constructor<ConstructorTest> constructor2 = clazz.getConstructor(int.class);

        System.out.println(constructor1);
        System.out.println(constructor2);

        Class<?>[] parameterTypes = constructor2.getParameterTypes();
        System.out.println(Arrays.toString(parameterTypes));

        ConstructorTest instance = constructor2.newInstance(2);

    }
}
