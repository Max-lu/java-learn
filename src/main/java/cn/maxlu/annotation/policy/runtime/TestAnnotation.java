package cn.maxlu.annotation.policy.runtime;

/**
 * Created by max.lu on 2016/1/26.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TestAnnotation {
    String name() default "max";
    int age() default 18;
}
