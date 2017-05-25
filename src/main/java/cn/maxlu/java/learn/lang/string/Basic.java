package cn.maxlu.java.learn.lang.string;

import org.junit.Test;

import java.util.StringJoiner;

/**
 * Created by luwei on 2017/4/7.
 */
public class Basic {
    @Test
    public void stringJoinerTest() {
        StringJoiner stringJoiner = new StringJoiner("-", "prefix", "suffix");
        stringJoiner.add("he");
        stringJoiner.add("he");
        stringJoiner.add("he");
        String toString = stringJoiner.toString();
        System.out.println(toString);
    }

    @Test
    public void test() {
        System.out.println("11");
        flag: {
            System.out.println("hello");
            int i = 1;
            while (++i != 10) {
                System.out.println("world");
                if (i == 5) {
                    break flag;
                }
            }

            System.out.println("333");
        }

        System.out.println("22");

    }
}
