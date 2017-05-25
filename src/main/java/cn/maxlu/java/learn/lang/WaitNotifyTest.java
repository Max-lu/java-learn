package cn.maxlu.java.learn.lang;

/**
 * Created by lw on 2016/7/18.
 */

public class WaitNotifyTest {

    private final static Object lock = new Object();

    public static void main(String[] args) throws Exception {

        WaitNotifyTest test = new WaitNotifyTest();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                test.doWait();
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test.doNotify();
            }
        };

        t1.start();
        t2.start();
    }

    private void doNotify() {
        System.out.println("start notify...");
        synchronized (lock) {
            lock.notify();
        }
    }

    private void doWait() {
        System.out.println("start wait...");
        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
