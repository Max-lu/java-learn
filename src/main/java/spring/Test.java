package spring;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {
    private static final ThreadPoolTaskExecutor poolTaskExecutor;

    static {
        poolTaskExecutor = new ThreadPoolTaskExecutor();
        poolTaskExecutor.setAllowCoreThreadTimeOut(true);
        poolTaskExecutor.setCorePoolSize(5);
        poolTaskExecutor.setKeepAliveSeconds(5000);
        poolTaskExecutor.setMaxPoolSize(10);
        poolTaskExecutor.setQueueCapacity(10000);
        poolTaskExecutor.initialize();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        for (int i = 0; i < 100; i++) {
            poolTaskExecutor.execute(new TestThread());
        }

        FutureTask<User> futureTask = new FutureTask<>(new HandlerUser());
        poolTaskExecutor.submit(futureTask);
        User user = futureTask.get();
        System.out.println(user.getName());
    }
}
