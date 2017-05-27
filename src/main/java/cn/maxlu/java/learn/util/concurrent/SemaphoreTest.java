package cn.maxlu.java.learn.util.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by luwei on 2017/5/25.
 */
public class SemaphoreTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();

        int need = 20;
        int permits = 5;

        Semaphore semaphore = new Semaphore(permits);

        //同时有5个线程可获得许可，其他线程等待
        for (int i = 0; i < need; i++) {
            int finalI = i;
            service.execute(()->{
                try {
                    semaphore.acquire();

                    System.out.println("get " + finalI);
                    Thread.sleep(5 * 1000);

                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        service.shutdown();
    }
}
