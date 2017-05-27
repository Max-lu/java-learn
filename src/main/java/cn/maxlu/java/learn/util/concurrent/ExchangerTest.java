package cn.maxlu.java.learn.util.concurrent;

import java.util.concurrent.Exchanger;

/**
 * Created by luwei on 2017/5/27.
 */
public class ExchangerTest {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        MyThread thread1 = new MyThread(exchanger, "hello");
        MyThread thread2 = new MyThread(exchanger, "world");

        thread1.start();
        thread2.start();
    }

    private static class MyThread extends Thread {

        private Exchanger<String> exchanger;

        private String object;

        MyThread(Exchanger<String> exchanger, String object) {
            this.exchanger = exchanger;
            this.object = object;
        }

        @Override
        public void run() {
            try {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " : exchange object [ " + object + " ]");
                String result = exchanger.exchange(object);
                System.out.println(threadName + " : get      object [ " + result + " ]");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
