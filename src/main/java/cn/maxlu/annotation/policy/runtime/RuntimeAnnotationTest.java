package cn.maxlu.annotation.policy.runtime;

import java.lang.reflect.Method;

/**
 * Created by max.lu on 2016/1/26.
 */
class RuntimeAnnotationTest {
    public static void main(String[] args) {
        SimpleObject simpleObject = new SimpleObject();
        for (Method m : SimpleObject.class.getMethods()) {
            if (m.isAnnotationPresent(TestAnnotation.class)) {
                try {
                    TestAnnotation annotation = m.getAnnotation(TestAnnotation.class);
                    String name = annotation.name();
                    int age = annotation.age();
                    System.out.println("name:" + name + " age:" + age);
                    System.out.println(m.getName());
                    m.invoke(simpleObject);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Method " + m + "run failed " + e.getCause());
                }
            }
        }
    }
}
