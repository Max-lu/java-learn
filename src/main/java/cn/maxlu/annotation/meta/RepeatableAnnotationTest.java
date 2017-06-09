package cn.maxlu.annotation.meta;

import java.lang.annotation.*;
import java.util.Arrays;

/**
 * Created by luwei on 2017/6/9.
 */

public class RepeatableAnnotationTest {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Repeatable(value = Roles.class)
    private @interface Role {
        String name();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    private @interface Roles {
        Role[] value();
    }


    @Role(name = "max1")
    @Role(name = "max2")
    private static class Child {

    }

    @Roles(value = {@Role(name = "max3"), @Role(name = "max4")})
    private static class Child2 {

    }

    public static void main(String[] args) {
        //方法一
        Roles annotation = Child.class.getAnnotation(Roles.class);
        System.out.println(Arrays.toString(annotation.value()));

        //方法二
        Role[] roles = Child.class.getAnnotationsByType(Role.class);
        for (Role role : roles) {
            System.out.println(role.name());
        }

    }
}
