package cn.maxlu.java.learn.reflect.basic;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Created by luwei on 2017/6/8.
 */
public class FieldTest {

    public FieldTest(int a, String b) {
        this.a = a;
        this.b = b;
    }

    public int a;

    public String b;

    public static void main(String[] args) throws Exception {
        Class<FieldTest> clazz = FieldTest.class;

        Field[] fields = clazz.getFields();
        System.out.println(Arrays.toString(fields));

        Field a = clazz.getField("a");
        Field b = clazz.getField("b");

        System.out.println(a);
        System.out.println(b);

        System.out.println(a.getType());
        System.out.println(b.getType());

        FieldTest fieldTest = new FieldTest(1, "hello");
        Object o1 = a.get(fieldTest);
        System.out.println(o1);

        a.set(fieldTest, 2);

        Object o2 = a.get(fieldTest);
        System.out.println(o2);
    }
}
