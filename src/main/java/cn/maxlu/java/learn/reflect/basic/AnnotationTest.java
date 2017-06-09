package cn.maxlu.java.learn.reflect.basic;

import java.lang.annotation.*;

/**
 * Created by luwei on 2017/6/8.
 */
public class AnnotationTest {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    private @interface MyAnnotation {
        String name();
        int value();
    }

    @Deprecated
    @MyAnnotation(name = "age", value = 123)
    private static class TestClass {

    }

    public static void main(String[] args) {
        Annotation[] annotations = TestClass.class.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof MyAnnotation) {
                MyAnnotation my = (MyAnnotation) annotation;
                System.out.println(my.name() + "=" + my.value());
            } else {
                System.out.println("others");
            }
        }

        MyAnnotation annotation = TestClass.class.getAnnotation(MyAnnotation.class);
        System.out.println(annotation.name() + "=" + annotation.value());
    }
}
