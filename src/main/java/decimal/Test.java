package decimal;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Test {
    public static void main(String[] args) {
        System.out.println(Math.round(3.015 * 100) / 100.0);
        NumberFormat instance = DecimalFormat.getInstance();
        System.out.println(instance.format(3.015));
    }
}
