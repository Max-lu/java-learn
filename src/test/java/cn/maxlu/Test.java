package cn.maxlu;

/**
 * Created by lw on 2016/7/18.
 */
public class Test {

    class Inner {
        public void test() {
            Test.this.test();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        new Test("hello").new Inner().test();
    }

    private String a;

    public Test(String a) {
        this.a = a;
    }

    public void test() {
        System.out.println(this.a);
    }
}
