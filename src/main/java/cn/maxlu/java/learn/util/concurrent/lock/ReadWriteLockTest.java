package cn.maxlu.java.learn.util.concurrent.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by luwei on 2017/6/6.
 */
public class ReadWriteLockTest {

    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
    private static final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();

    public static void main(String[] args) throws InterruptedException {
        m1();
    }

    private static void m1() throws InterruptedException {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                read();
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                write();
            }
        };

        thread1.start();
        Thread.sleep(200);
        thread2.start();
    }

    private static void read1() {
        System.out.println("read1 get lock");
        readLock.lock();

        System.out.println("read1 ...");
        read2();
        readLock.unlock();
        System.out.println("read1 release lock");
    }

    private static void read2() {
        System.out.println("read2 get lock");
        readLock.lock();
        System.out.println("read2 ...");
        readLock.unlock();
        System.out.println("read2 release lock");
    }

    private static void write1() {
        System.out.println("write1 get lock");
        readLock.lock();

        System.out.println("write1 ...");
        write2();
        readLock.unlock();
        System.out.println("write1 release lock");
    }

    private static void write2() {
        System.out.println("write2 get lock");
        readLock.lock();
        System.out.println("write2 ...");
        readLock.unlock();
        System.out.println("write2 release lock");
    }

    private static void read() {
        System.out.println("read get lock");
        readLock.lock();

        System.out.println("read ...");
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        readLock.unlock();
        System.out.println("read release lock");
    }

    private static void write() {
        System.out.println("write get lock");
        writeLock.lock();

        System.out.println("write ...");
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        writeLock.unlock();
        System.out.println("write release lock");
    }
}
