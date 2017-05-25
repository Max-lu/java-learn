package cn.maxlu.java.learn.lang.thread;

/**
 * Created by max.lu on 2016/3/2.
 */
public class ThreadTest {
    public static void main(String[] args) {
        testThreadDemo2();
    }

    private static void testThreadDemo1() {
        ThreadDemo1 thread1 = new ThreadDemo1();
        ThreadDemo1 thread2 = new ThreadDemo1();
        ThreadDemo1 thread3 = new ThreadDemo1();
        thread1.start();
        thread2.start();
        thread3.start();
    }

    private static void testThreadDemo2() {
        ThreadDemo2 thread1 = new ThreadDemo2();
        ThreadDemo2 thread2 = new ThreadDemo2();
        ThreadDemo2 thread3 = new ThreadDemo2();
        Thread th1 = new Thread(thread1);
        Thread th2 = new Thread(thread2);
        Thread th3 = new Thread(thread3);
        th1.start();
        th2.start();
        th3.start();
    }
}
