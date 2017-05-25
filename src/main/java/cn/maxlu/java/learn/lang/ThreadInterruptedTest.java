package cn.maxlu.java.learn.lang;

/**
 * Created by lw on 2016/7/18.
 */

public class ThreadInterruptedTest {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                try {
                    System.out.println("Thread t1 sleep 10 seconds");
                    Thread.sleep(10 * 1000);
                } catch (InterruptedException e) {
                    //isInterrupted方法总是返回false，因为此时中断状态已被重置
                    System.out.println("Thread t1 is interrupted? -> " + Thread.currentThread().isInterrupted());
                    System.out.println("Thread t1 was interrupted");
                    System.out.println("Thread t1 state : " + Thread.currentThread().getState());
                }
            }
        };

        Thread t2 = new Thread("t2") {
            @Override
            public void run() {
                t1.interrupt();
            }
        };

        t1.start();
        Thread.sleep(2 * 1000);
        t2.start();

        Thread.sleep(10 * 1000);
    }

}
