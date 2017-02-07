package date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatTest {
    public static void main(String[] args) {
        String pattern = "yyyy-MMM-dd HH:mm:ss.SSS";
        SimpleDateFormat sf = new SimpleDateFormat(pattern);
        Date date = new Date();
        String dateString = sf.format(date);
        System.out.println(dateString);
    }
}
