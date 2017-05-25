package cn.maxlu.java.learn.basic.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by luwei on 2017/4/7.
 */
public class BasicTest {

    @Test
    public void define() {
        String[] a = new String[10];

        String[] b = new String[]{"h", "e", "l", "l", "o"};

        String[] c = {"h", "e", "l", "l", "o"};

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
    }

    @Test
    public void test2() {
        char[]  a = {'a', 'b'};
        System.out.println(a);
        System.out.println(a.length);

        char[] b = Arrays.copyOf(a, 10);
        System.out.println(b);
        System.out.println(b.length);
    }

    @Test
    public void test3() {
        String a = "123";
        String intern = a.intern();
        System.out.println(intern);
    }
}
