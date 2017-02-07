package staticTest;

/**
 * Created by max.lu on 2016/3/10.
 */
public class Test {
    static int a = 1;

    public static void main(String[] args) {
        new Test().foo();
        foo1();
    }

    private void foo() {
        int a = 2;
        System.out.println(this.a);
        System.out.println(a);
    }

    private static void foo1() {
        int a = 3;
        System.out.println(a);
    }
}
