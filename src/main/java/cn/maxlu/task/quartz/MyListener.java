package cn.maxlu.task.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.quartz.SchedulerException;

public class MyListener implements JobListener {
    @Override
    public String getName() {
        return "my listener";
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext jobExecutionContext) {
        System.out.println("job to be executed");
    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext jobExecutionContext) {
        System.out.println("job execution vetoed");
    }

    @Override
    public void jobWasExecuted(JobExecutionContext jobExecutionContext, JobExecutionException e) {
            if (e != null) {
                try {
                    jobExecutionContext.getScheduler().shutdown();
                    System.out.println("error occur, shutdown schedule");
                } catch (SchedulerException e1) {
                    e1.printStackTrace();
                }
            }
    }
}
