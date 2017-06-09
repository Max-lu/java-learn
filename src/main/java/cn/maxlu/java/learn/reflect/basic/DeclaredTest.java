package cn.maxlu.java.learn.reflect.basic;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by luwei on 2017/6/8.
 */
public class DeclaredTest {

    public static void main(String[] args) throws Exception {
        TestClass testClass = new TestClass("max");

        Field nameField = TestClass.class.getDeclaredField("name");
        nameField.setAccessible(true); //notice
        System.out.println(nameField.get(testClass));

        Method getNameMethod = TestClass.class.getDeclaredMethod("getName");
        getNameMethod.setAccessible(true); //notice
        Object result = getNameMethod.invoke(testClass);
        System.out.println(result);
    }


}

class TestClass {
    private String name;

    private String getName() {
        return name;
    }

    TestClass(String name) {
        this.name = name;
    }
}
