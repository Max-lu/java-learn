package annotation;

import java.lang.reflect.Method;

/**
 * Created by max.lu on 2016/1/26.
 */
public class HandleTestAnnotation {
    public static void process(String clazz) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Object o = Class.forName(clazz).newInstance();
        for (Method m : Class.forName(clazz).getMethods()) {
            if (m.isAnnotationPresent(TestAnnotation.class)) {
                try {
                    TestAnnotation annotation = m.getAnnotation(TestAnnotation.class);
                    String name = annotation.name();
                    int age = annotation.age();
                    System.out.println("name:" + name + " age:" + age);
                    System.out.println(m.getName());
                    m.invoke(o);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Method " + m + "run failed " + e.getCause());
                }
            }
        }
    }
}
