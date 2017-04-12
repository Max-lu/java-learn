package java8.date;

import org.junit.Test;

import java.time.*;
import java.util.Date;

/**
 * Created by luwei on 2017/4/7.
 */

public class Convert {

    @Test
    public void date2LocalDateTime() {
        Date date = new Date();
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println(localDateTime);
        LocalDate localDate = localDateTime.toLocalDate();
        System.out.println(localDate);
        LocalTime localTime = localDateTime.toLocalTime();
        System.out.println(localTime);
    }

    @Test
    public void LocalDateTime2Date() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);
        System.out.println(date);

        LocalDate localDate = LocalDate.now();
        Instant instant2 = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        Date date2 = Date.from(instant2);
        System.out.println(date2);

        LocalTime localTime = LocalTime.now();
        Instant instant3 = LocalDateTime.of(localDate, localTime).atZone(ZoneId.systemDefault()).toInstant();
        Date date3 = Date.from(instant3);
        System.out.println(date3);
    }
}
