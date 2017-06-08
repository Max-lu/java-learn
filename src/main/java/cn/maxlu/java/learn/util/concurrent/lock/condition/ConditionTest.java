package cn.maxlu.java.learn.util.concurrent.lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by luwei on 2017/6/6.
 */
public class ConditionTest {

    public static void main(String[] args) throws Exception {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Consumer consumer = new Consumer(condition, lock);
        Producer producer = new Producer(condition, lock);

        consumer.start();
        //同时启动consumer可能错过信号
        Thread.sleep(2 * 1000);
        producer.start();
    }

    private static class Consumer extends Thread {
        private Lock lock;

        private Condition condition;

        Consumer(Condition condition, Lock lock) {
            this.condition = condition;
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println("consumer get lock");
                System.out.println("consumer wait...");
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println("consumer release lock");
            }
        }
    }

    private static class Producer extends Thread {
        private Lock lock;

        private Condition condition;

        Producer(Condition condition, Lock lock) {
            this.condition = condition;
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println("producer get lock");
                System.out.println("producer signal...");
                condition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println("producer release lock");
            }
        }
    }
}
