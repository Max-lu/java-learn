package cn.maxlu.java.learn.threadpool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by luwei on 2017/4/11.
 */
public class ThreadPoolTest {

    /**
     * 无限容量的线程池，对空闲的线程加以复用，没有空闲线程则创建一个新线程
     * 超过60s空闲的线程将被回收
     */
    @Test
    public void newCachedThreadPoolTest() {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            service.execute(() -> {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 固定容量的线程池
     * 没有可用线程时，后续任务在无界的队列中等待
     * 线程失败时，一个新线程将代替此线程执行后续步骤
     */
    @Test
    public void newFixedThreadPoolTest() {
        ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            service.execute(() -> {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 单线程
     * 后续任务在无界的队列中等待
     * 线程失败时，一个新线程将代替此线程执行后续步骤
     * 和{@code newFixedThreadPool(1)}的不同在于后者可以通过setCorePoolSize(3)方法修改线程池大小，而
     * newSingleThreadExecutor可以保证只有一个线程
     */
    @Test
    public void newSingleThreadExecutorTest() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            service.execute(() -> {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 固定容量线程池
     * 可以按照给定的延时执行任务，或按照给定的时间间隔周期性的执行任务
     */
    @Test
    public void newScheduledThreadPoolTest() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
        service.scheduleAtFixedRate(() -> System.out.println(Thread.currentThread().getName()), 5, 2, TimeUnit.SECONDS);
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用jconsole工具观察线程变化情况
     * 可观测到线程峰值达到10000+
     * @throws InterruptedException
     */
    @Test
    public void jconsoleTest() throws InterruptedException {
        //等待jconsole连接
        Thread.sleep(20 * 1000);

        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 10000; i++) {
            service.execute(() -> {
                while (true) {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        //占用线程，100s后释放
                        Thread.sleep(100 * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        Thread.sleep(20 * 1000);
    }

}
