package cn.maxlu;

/**
 * Created by luwei on 2017/5/17.
 */
public class A {
    synchronized void m1() throws InterruptedException {
        System.out.println("m1");
        Thread.sleep(100 * 1000);
    }

    synchronized void m2() throws InterruptedException {
        System.out.println("m2");
        Thread.sleep(100 * 1000);
    }
}
