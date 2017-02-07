package task.schedule;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test2 implements Runnable {
    private String name;

    public Test2(String name) {
        super();
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this.name + " run...");
        System.out.println("time = " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
    }

    private Calendar getNearestCalendar(Calendar current, int dayOfWeek, int hourOfDay, int minuteOfHour, int secondOfMinute) {
        int currentWeekOfYear = current.get(Calendar.WEEK_OF_YEAR);
        int currentDayOfWeek = current.get(Calendar.DAY_OF_WEEK);
        int currentHourOfDay = current.get(Calendar.HOUR_OF_DAY);
        int currentMinuteOfHour = current.get(Calendar.MINUTE);
        int currentSecondOfMinute = current.get(Calendar.SECOND);

        Calendar calendar = Calendar.getInstance();
        boolean isNextWeek = false;
        if (currentDayOfWeek > dayOfWeek) {
            isNextWeek = true;
        } else if (currentDayOfWeek == dayOfWeek) {
            if (currentHourOfDay > hourOfDay) {
                isNextWeek = true;
            } else if (currentHourOfDay == hourOfDay) {
                if (currentMinuteOfHour > minuteOfHour) {
                    isNextWeek = true;
                } else if (currentMinuteOfHour == minuteOfHour) {
                    if (currentSecondOfMinute > secondOfMinute) {
                        isNextWeek = true;
                    }
                }
            }
        }
        if (isNextWeek) {
            calendar.set(Calendar.WEEK_OF_YEAR, currentWeekOfYear + 1);
        }
        calendar.set(Calendar.DAY_OF_WEEK, dayOfWeek);
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        calendar.set(Calendar.MINUTE, minuteOfHour);
        calendar.set(Calendar.SECOND, secondOfMinute);
        return calendar;
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2("job");

        Calendar current = Calendar.getInstance();
        long currentTime = current.getTime().getTime();

        Calendar nearestCalendar = test2.getNearestCalendar(current, 2, 19, 5, 0);
        long nearestTime = nearestCalendar.getTime().getTime();

        System.out.println("Job will be executed on " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(nearestCalendar.getTime()));

        long delay = nearestTime - currentTime;
        long period = 7 * 24 * 60 * 60 * 1000;
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        service.scheduleAtFixedRate(test2, delay, period, TimeUnit.MILLISECONDS);
    }
}
