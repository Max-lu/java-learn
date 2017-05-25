package cn.maxlu.java.learn.lang.threadlocal;

/**
 * Created by luwei on 2017/5/8.
 */
public class ThreadLocalTest2 {

    private static ThreadLocal<String> v1 = new ThreadLocal<>();
    private static String v2 = null;

    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();
    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            v1.set(threadName);
            v2 = threadName;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + "-v1:" + v1.get());
            System.err.println(threadName + "-v2:" + v2);
        }
    }
}
