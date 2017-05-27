package cn.maxlu.java.learn.util.concurrent;

import java.util.Arrays;
import java.util.concurrent.*;

/**
 * Created by luwei on 2017/5/16.
 */
public class CountDownLatchTest {

    private static final CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        System.out.println("count down begin:");

        MyTask myTask = new MyTask();
        service.invokeAll(Arrays.asList(myTask, myTask));
        //主线程阻塞，等待其他线程执行countDown。一个线程可执行多次countDown
        countDownLatch.await();

        System.out.println(countDownLatch.getCount());
        service.shutdown();
        System.out.println("count down end");
    }

    private static class MyTask implements Callable<Void> {
        @Override
        public Void call() throws Exception {
            Thread.sleep(2 * 1000);
            System.out.println(countDownLatch.getCount());
            countDownLatch.countDown();
            return null;
        }
    }
}
