package cn.maxlu.java.learn.lang.string;

/**
 * Created by max.lu on 2016/3/3.
 */
public class StringTest {
    public static void main(String[] args) {
        // == 比较内存地址
        method3();
    }

    private static void method1() {
        String a = "abc";
        String b = "abc";
        System.out.println(a == b);
        System.out.println(a.equals(b));

        String c = new String("abc");
        System.out.println(a == c);
        System.out.println(a.equals(c));

        System.out.println(a == c.intern());
    }

    private static void method2() {
        String a = "abc";
        String a1 = new String("abc");
        String a2 = a1.trim() + "";//new
        String a3 = "abc" + "";
        String a4 = "abc".trim() + "";
        System.out.println(a == a1);
        System.out.println(a.intern() == a1.intern());
        System.out.println(a1 == a2);
        System.out.println(a3 == a);
        System.out.println(a4 == a);
    }

    private static void method3() {
        int a1 = 1;
        int a2 = 1;
        Integer b1 = new Integer(1);
        Integer b2 = new Integer(1);
        System.out.println(a1 == a2);
        System.out.println(a1 == b1);
        System.out.println(b1 == b2);
        System.out.println(b1.equals(b2));
    }
}
