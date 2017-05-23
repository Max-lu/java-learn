package cn.maxlu.java.learn.util.concurrent.lock.synchronizedd;

import java.util.concurrent.CountDownLatch;

/**
 * Created by luwei on 2017/5/23.
 */
@SuppressWarnings("unused")
public class SynchronizedTest {
    public static void main(String[] args) throws Exception{
        SynchronizedTest test = new SynchronizedTest();

        new Thread() {
            @Override
            public void run() {
                try {
                    SynchronizedTest.m5();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    SynchronizedTest.m6Same();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private CountDownLatch countDownLatch = new CountDownLatch(1);

    //非静态方法锁住的是this，即对象本身
    //所有调用其他非静态synchronized方法都会被阻塞
    //m1和m2为典型的死锁案例
    private synchronized void m1() throws Exception {
        System.out.println("await...");
        countDownLatch.await();
    }

    private synchronized void m2() throws Exception {
        System.out.println("count down");
        countDownLatch.countDown();
    }

    private void m1Same() throws Exception {
        synchronized (this) {
            System.out.println("await...");
            countDownLatch.await();
        }
    }


    private synchronized void m3() throws Exception {
        System.out.println("m3 start...");
        Thread.sleep(2 * 1000);
        System.out.println("m3 end...");
    }

    private synchronized void m4() throws Exception {
        System.out.println("m4 start...");
        Thread.sleep(2 * 1000);
        System.out.println("m4 end...");
    }


    //静态方法锁住的是此对象对应的class实例
    private static synchronized void m5() throws Exception {
        System.out.println("m5 start...");
        Thread.sleep(2 * 1000);
        System.out.println("m5 end...");
    }

    private static synchronized void m6() throws Exception {
        System.out.println("m6 start...");
        Thread.sleep(2 * 1000);
        System.out.println("m6 end...");
    }

    private static void m6Same() throws Exception {
        synchronized (SynchronizedTest.class) {
            System.out.println("m6 start...");
            Thread.sleep(2 * 1000);
            System.out.println("m6 end...");
        }
    }
}
