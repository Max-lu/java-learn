package cn.maxlu.java.learn.util.concurrent.executor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by luwei on 2017/5/25.
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Set<Callable<String>> callables = new HashSet<>();

        Callable<String> callable = () -> {
            Thread.sleep(3000);
            System.out.println("callable execute");
            return "Task 1";
        };
        callables.add(callable);

        Runnable runnable = () -> {
            try {
                Thread.sleep(1000);
                System.out.println("runnable execute");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        /**
         * execute(Runnable)
         * submit(Runnable)
         * submit(Callable)
         * 都是异步执行的
         */

        System.out.println("-------------");
        Future future = executorService.submit(callable);
        System.out.println("flag 1");
        System.out.println(future.get());

        System.out.println("-------------");
        Future<?> future2 = executorService.submit(runnable);
        System.out.println("flag 2");
        System.out.println(future2.get()); //always null

        System.out.println("-------------");
        Future<String> future3 = executorService.submit(runnable, "hello");
        System.out.println("flag 3");
        System.out.println(future3.get()); //always hello

        System.out.println("-------------");
        executorService.execute(runnable); //without return
        System.out.println("flag 4");

        Thread.sleep(5 * 1000);


        /**
         * invokeAny(...)
         * invokeAll(...)
         * 是同步阻塞执行的
         */

        System.out.println("-------------");
        List<Future<String>> futures = executorService.invokeAll(callables);
        System.out.println("flag 5");
        for (Future<String> stringFuture : futures) {
            System.out.println(stringFuture.get());
        }

        System.out.println("-------------");
        String result = executorService.invokeAny(callables);
        System.out.println("flag 6");
        System.out.println(result);

        executorService.shutdown();
    }


}
