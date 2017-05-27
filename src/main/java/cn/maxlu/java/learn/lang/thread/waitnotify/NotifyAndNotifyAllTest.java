package cn.maxlu.java.learn.lang.thread.waitnotify;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by luwei on 2017/5/25.
 */
public class NotifyAndNotifyAllTest {

    private static final Object lock = new Object();

    private static final boolean NOTIFY_ALL = false;

    public static void main(String[] args) throws Exception {
        Thread thread1 = new MyThread("thread1");
        Thread thread2 = new MyThread("thread2");
        Thread thread3 = new MyThread("thread3");
        Thread thread4 = new MyThread("thread4");
        Thread thread5 = new MyThread("thread5");

        synchronized (lock) {
            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
            thread5.start();

            Thread.sleep(1000);
            System.out.println(thread1.getState());
            System.out.println(thread2.getState());
            System.out.println(thread3.getState());
            System.out.println(thread4.getState());
            System.out.println(thread5.getState());
        }

        if (NOTIFY_ALL) {
            Thread.sleep(2 * 1000);
            synchronized (lock) {
                lock.notifyAll();
            }
        } else {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(2 * 1000);
                synchronized (lock) {
                    lock.notify();
                }
            }
        }
    }

    private static class MyThread extends Thread {

        MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(this.getName() + " notified at " + getDate());
        }

        private String getDate() {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
            return sdf.format(new Date());
        }
    }

}
