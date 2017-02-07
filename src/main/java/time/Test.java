package time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by max.lu on 2016/3/9.
 */
//todo of from

public class Test {
    public static void main(String[] args) {
        method14();
    }

    private static void method1() {
        //before8
        Date date1 = new Date();
        System.out.println(date1);

        //after8
        LocalDate date2 = LocalDate.now();
        System.out.println(date2);
    }

    private static void method2() {
        //before 8
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year0 = calendar.get(Calendar.YEAR);
        int month0 = calendar.get(Calendar.MONTH);
        int day0 = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.printf("year: %d ,month: %d , day: %d \n", year0, month0, day0);

        //after 8
        LocalDate localDate = LocalDate.now();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        System.out.printf("year: %d ,month: %d , day: %d \n", year, month, day);
    }

    private static void method3() {
        //before 8
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sf.parse("2011-02-04");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);
        //after 8
        LocalDate localDate = LocalDate.of(2011, 2, 4);
        System.out.println(localDate);
    }

    private static void method4() {
        //before 8
        Date date1 = new Date();
        Date date2 = new Date();
//        boolean isEqual0 = date1.compareTo(date2) == 0; //时间也比较
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String d1 = sf.format(date1);
        String d2 = sf.format(date2);
        boolean isEqual0 = d1.equals(d2);
        System.out.println(isEqual0);
        //after 8
        LocalDate localDate1 = LocalDate.of(2011, 2, 4);
        LocalDate localDate2 = LocalDate.of(2011, 2, 4);
        boolean isEqual = localDate1.equals(localDate2);
        System.out.println(isEqual);
    }

    private static void method5() {

        //after 8
        LocalDate dayOfBirth = LocalDate.of(2016, 3, 9);
        LocalDate today = LocalDate.now();
        MonthDay birthday = MonthDay.of(dayOfBirth.getMonthValue(), dayOfBirth.getDayOfMonth());
        MonthDay now = MonthDay.from(today);
        if (birthday.equals(now)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    private static void method6() {
        //before 8
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("HH:mm:ss.SSS");
        String dateString = sf.format(date);
        System.out.println(dateString);
        //after 8
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
    }

    private static void method7() {
        //before 8
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, 2);
        Date newDate = calendar.getTime();
        System.out.println(date);
        System.out.println(newDate);

        //after 8
        LocalTime localTime = LocalTime.now();
        LocalTime nowTime = localTime.plusHours(2);
        System.out.println(localTime);
        System.out.println(nowTime);
    }

    private static void method8() {

        //after 8
        LocalDate localDate = LocalDate.of(2016, 2, 29);
        LocalDate nextWeek = localDate.plus(1, ChronoUnit.WEEKS);
        System.out.println(nextWeek);

        LocalDate nextYear = localDate.plus(1, ChronoUnit.YEARS);
        System.out.println(nextYear);
    }

    private static void method9() {

        //after 8
        Clock clock = Clock.systemUTC();
        System.out.println(clock);
        System.out.println(LocalTime.now(clock));
        System.out.println("-------");
        Clock clock1 = Clock.systemDefaultZone();
        System.out.println(clock1);
        System.out.println(LocalTime.now(clock1));
    }

    private static void method10() {

        //after 8
        LocalTime localTime0 = LocalTime.of(1, 1, 1);
        LocalTime localTime1 = LocalTime.of(2, 2, 2);
        System.out.println(localTime0.isAfter(localTime1));
        System.out.println(localTime0.isBefore(localTime1));
    }

    private static void method11() {

        //after 8
        ZoneId zoneId = ZoneId.of("America/New_York");
        LocalDateTime china = LocalDateTime.now();
        ZonedDateTime america = ZonedDateTime.of(china, zoneId);
        System.out.println("china: " + china);
        System.out.println("america: " + america.toInstant());

        Instant instant = america.toInstant();
        System.out.println(instant.atZone(ZoneId.of("UTC")).toInstant());//todo

        System.out.println("utc: " + ZonedDateTime.of(LocalDateTime.now(ZoneId.of("UTC")), ZoneId.of("UTC")));
    }

    private static void method12() {

        //after 8
        YearMonth current = YearMonth.now();
        System.out.println(current);
        System.out.println(current.lengthOfMonth());

        YearMonth yearMonth = YearMonth.of(2011, Month.APRIL);
        System.out.println(yearMonth);

    }

    private static void method13() {
        LocalDate localDate = LocalDate.now();
        boolean isLeapYear = localDate.isLeapYear(); //todo logic
        System.out.println(isLeapYear);
    }

    private static void method14() {
        LocalDate localDate0 = LocalDate.of(2011, 2, 2);
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate0);
        System.out.println(localDate);
        Period period = Period.between(localDate0, localDate);
        System.out.println(period.getDays());
        System.out.println(period.getMonths());
        System.out.println(period.getYears());
        System.out.println(period.getChronology());
        System.out.println(period.getUnits());
        System.out.println(period.get(ChronoUnit.DAYS));
    }
}
