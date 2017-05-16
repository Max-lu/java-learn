package task.schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test implements Runnable {
    private String name;

    public Test(String name) {
        super();
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this.name + " run...");
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        service.schedule(new Test("job1"), 1, TimeUnit.SECONDS);
        //ScheduleWithFixedDelay 每次执行时间为上一次任务结束起向后推一个时间间隔
        service.scheduleWithFixedDelay(new Test("job2"), 1, 1, TimeUnit.SECONDS);
        //ScheduleAtFixedRate 每次执行时间为上一次任务开始起向后推一个时间间隔
        service.scheduleAtFixedRate(new Test("job3"), 1, 1, TimeUnit.SECONDS);
    }
}
