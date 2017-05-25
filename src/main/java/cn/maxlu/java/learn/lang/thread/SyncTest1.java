package cn.maxlu.java.learn.lang.thread;

/**
 * Created by max.lu on 2016/3/2.
 */
public class SyncTest1 {
    public static void main(String[] args) {
        final SyncClass syncClass = new SyncClass();
        ThreadDemo3 thread1 = new ThreadDemo3("thread1", syncClass);
        ThreadDemo3 thread2 = new ThreadDemo3("thread2", syncClass);
        thread1.start();
        thread2.start();
    }
}
