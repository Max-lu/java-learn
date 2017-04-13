package cn.maxlu.java8.date;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by luwei on 2017/4/7.
 */
public class Basic {
    
    @Test
    public void format() {
        String dateString = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
        System.out.println(dateString);
    }

    @Test
    public void getYMD() {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonth().getValue();
        int day = now.getDayOfMonth();
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);
    }
    
    @Test
    public void operate() {
        //before 8
        Date date = new Date();
        long time = date.getTime() + 24 * 60 * 60 * 1000;
        date.setTime(time);
        System.out.println(date);

        //since 8
        LocalDateTime tomorrow = LocalDateTime.now().plusDays(1);
        System.out.println(tomorrow);
    }
    
    @Test
    public void getSeconds() {
        long milliSeconds = Instant.now().toEpochMilli();
        long seconds = Instant.now().getEpochSecond();
        System.out.println(milliSeconds);
        System.out.println(seconds);
    }
}
