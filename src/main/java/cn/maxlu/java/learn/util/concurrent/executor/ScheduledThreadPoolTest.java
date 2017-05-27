package cn.maxlu.java.learn.util.concurrent.executor;

import java.util.concurrent.*;

/**
 * Created by luwei on 2017/5/27.
 */
public class ScheduledThreadPoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);

        Runnable runnable = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("runnable execute");
        };

        Callable<String> callable = () -> {
            Thread.sleep(1000);
            System.out.println("callable execute");
            return "success";
        };


        System.out.println("---------------");
        ScheduledFuture<?> future1 = service.schedule(runnable, 5, TimeUnit.SECONDS);
        System.out.println("flag 1");
        System.out.println(future1.get()); //always null

        System.out.println("---------------");
        ScheduledFuture<String> future2 = service.schedule(callable, 5, TimeUnit.SECONDS);
        System.out.println("flag 2");
        System.out.println(future2.get());

        System.out.println("---------------");
        /**
         * 5秒之后第一次执行runnable，之后每两秒执行一次，直到某次执行出现异常或者ScheduledExecutorService关闭。
         * 如果某次执行时间超过执行间隔（这里是2秒），则下次执行在这次执行完成后。
         * 这个调度任务不会同时被多个线程执行。
         * 时间间隔（period）是指上一次执行开始时间 和 下一次执行开始时间 之间的间隔
         */
//        ScheduledFuture<?> future3 = service.scheduleAtFixedRate(runnable, 5, 2, TimeUnit.SECONDS);
        System.out.println("flag 3");
        //System.out.println(future3.get()); //always block


        System.out.println("---------------");
        /**
         * 时间间隔（period）是指上一次执行结束时间 和 下一次执行开始时间 之间的间隔
         */
        ScheduledFuture<?> future4 = service.scheduleWithFixedDelay(runnable, 5, 2, TimeUnit.SECONDS);
        System.out.println("flag 4");
        //System.out.println(future4.get()); //always block


        Thread.sleep(20 * 1000);
        service.shutdown();
    }
}
