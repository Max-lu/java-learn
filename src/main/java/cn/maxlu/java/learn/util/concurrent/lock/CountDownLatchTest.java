package cn.maxlu.java.learn.util.concurrent.lock;

import java.util.Arrays;
import java.util.concurrent.*;

/**
 * Created by luwei on 2017/5/16.
 */
public class CountDownLatchTest {

    private static final CountDownLatch countDownLatch = new CountDownLatch(2);

    private static final ExecutorService service = Executors.newFixedThreadPool(2);


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("count down begin:");

        MyTask myTask = new MyTask();
        service.invokeAll(Arrays.asList(myTask, myTask));
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
