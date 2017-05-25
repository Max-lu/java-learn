package cn.maxlu.java.learn.basic.enumeration;

import java.util.Arrays;

/**
 * Created by max.lu on 2016/1/27.
 */
public class EnumTest {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Person.values()));

        System.out.println(Person.parse("child"));

        if (Person.persons.contains(Person.parse("man"))) {
            System.out.println("success");
        }

        System.out.println(Person.WOMAN.ordinal());
    }
}
