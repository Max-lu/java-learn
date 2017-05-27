package cn.maxlu.java.learn.util.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by luwei on 2017/5/25.
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        int parties = 3;

        CyclicBarrier cyclicBarrier = new CyclicBarrier(parties, () -> {
            System.out.println("done");
        });

        ExecutorService service = Executors.newCachedThreadPool();

        //三个线程互相等待
        for (int i = 0; i < parties; i++) {
            int finalI = i;
            service.execute(()->{
                System.out.println("finish step " + finalI);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }

        service.shutdown();
    }
}
