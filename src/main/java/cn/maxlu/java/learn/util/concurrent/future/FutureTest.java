package cn.maxlu.java.learn.util.concurrent.future;

import java.util.concurrent.*;

/**
 * Created by luwei on 2017/5/16.
 */
public class FutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();

        Future<String> future = service.submit(() -> {
            Thread.sleep(5000);
            return "hello world";
        });

        System.out.println("do other things...");

        if (!future.isDone()) {
            System.out.println("task is processing...");
        }
        try {
            String resp = future.get(2, TimeUnit.SECONDS);
            System.out.println("resp=" + resp);
        } catch (TimeoutException e) {
            System.out.println("process timeout");
            if (!future.isCancelled()) {
                future.cancel(true);
                System.out.println("task has cancelled");
            }
        }

//        String resp = future.get();
//        System.out.println("resp=" + resp);
        service.shutdown();
    }
}
