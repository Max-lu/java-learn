package cn.maxlu.java.learn.util.threadlocal;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by luwei on 2017/5/18.
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new MyTask()).start();
        }
    }


    private static class MyTask implements Runnable {

        //全局事务
        //避免顺着方法一直往下传递
        private static ThreadLocal<String> transactionId = new ThreadLocal<String>() {
            @Override
            protected String initialValue() {
                return UUID.randomUUID().toString();
            }
        };

        //线程名
        private static ThreadLocal<String> threadName = new ThreadLocal<String>() {
            @Override
            protected String initialValue() {
                return Thread.currentThread().getName();
            }
        };

        @Override
        public void run() {
            System.out.println("thread " + threadName.get() + "start, transactionId=" + transactionId.get());

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("thread " + threadName.get() + "stop , transactionId=" + transactionId.get());

            //释放的目的：
            //1、线程池模式中此线程可能被复用
            //2、释放关联的对象，以便gc
            threadName.remove();
            transactionId.remove();
        }
    }
}

