package cn.maxlu.task.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuartzTest implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String name = jobExecutionContext.getJobDetail().getName();
        String description = jobExecutionContext.getJobDetail().getDescription();
        String fullName = jobExecutionContext.getJobDetail().getFullName();
        Object type = jobExecutionContext.getJobDetail().getJobDataMap().get("type");
        String[] jobListenerNames = jobExecutionContext.getJobDetail().getJobListenerNames();
        System.out.println(String.format("name=%s,description=%s,fullName=%s,type=%s,listener=%s", name, description, fullName, type, Arrays.toString(jobListenerNames)));
        System.out.println("time = " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
        throw new JobExecutionException("test exception");
    }

    public static void main(String[] args) throws SchedulerException, ParseException {
        listener();
    }

    private static void listener() throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        MyListener jobListener = new MyListener();
        scheduler.addJobListener(jobListener);
        JobDetail jobDetail = new JobDetail("myJob2", "myGroup2", QuartzTest.class);
        jobDetail.addJobListener(jobListener.getName());
        Trigger trigger = new SimpleTrigger("mySimpleTrigger", "mySimpleTriggerGroup", new Date(System.currentTimeMillis() + 5 * 1000), null, 0, 2000);
        scheduler.scheduleJob(jobDetail, trigger);
    }

    private static void cronTrigger() throws ParseException, SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        JobDetail jobDetail = new JobDetail("myJob3", "myGroup3", QuartzTest.class);
        CronTrigger cronTrigger = new CronTrigger("myCronTrigger", "myCronTriggerGroup");
        cronTrigger.setCronExpression("0/10 0 * * * ?");
        scheduler.scheduleJob(jobDetail, cronTrigger);
    }

    private static void simpleTrigger() throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        JobDetail jobDetail = new JobDetail("myJob2", "myGroup2", QuartzTest.class);
        Trigger trigger = new SimpleTrigger("mySimpleTrigger", "mySimpleTriggerGroup", new Date(System.currentTimeMillis() + 30 * 1000), null, 0, 2000);
        scheduler.scheduleJob(jobDetail, trigger);
    }

    private static void job1() throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        JobDetail jobDetail = new JobDetail("myJob", "myGroup", QuartzTest.class);
        jobDetail.getJobDataMap().put("type", "FULL");

        Trigger trigger = TriggerUtils.makeWeeklyTrigger(2, 19, 7);
        trigger.setName("myTrigger");
        trigger.setGroup("myTriggerGroup");
        trigger.setStartTime(TriggerUtils.getEvenSecondDate(new Date()));

        scheduler.scheduleJob(jobDetail, trigger);
    }
}
