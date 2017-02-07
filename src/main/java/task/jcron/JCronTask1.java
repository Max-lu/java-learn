package task.jcron;

import java.util.Date;

public class JCronTask1 {
    private static int count = 0;

    public static void main(String[] args) {
        System.out.println("--------------Task1-----------------");
        System.out.println("Current Time = " + new Date() + ", Count = " + count++);
    }
}
