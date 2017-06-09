package cn.maxlu.annotation.meta;

import java.lang.annotation.*;
import java.util.Arrays;

/**
 * Created by luwei on 2017/6/9.
 */

public class InheritedAnnotationTest {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Inherited
    private @interface InheritedAnnotation {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Inherited
    private @interface InheritedAnnotation2 {
        String value();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    private @interface NoInheritedAnnotation {
    }

    @InheritedAnnotation
    @InheritedAnnotation2(value = "hello")
    @NoInheritedAnnotation
    private static class Parent {

    }

    //覆盖父类注解
    @InheritedAnnotation2(value = "world")
    private static class Child extends Parent {

    }

    public static void main(String[] args) {
        Annotation[] annotations = Child.class.getAnnotations();
        System.out.println(Arrays.toString(annotations));

        InheritedAnnotation2 annotation = Child.class.getAnnotation(InheritedAnnotation2.class);
        System.out.println(annotation.value());
    }
}
