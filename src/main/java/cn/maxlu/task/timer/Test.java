package cn.maxlu.task.timer;

import java.util.Timer;
import java.util.TimerTask;

public class Test {
    public static void main(String args[]) {
        myTimer();
    }

    public static void myTimer() {
        Timer timer = new Timer();
        timer.schedule(new MyTask(), 1000, 1000);
    }

    static class MyTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("Time's up!");
        }
    }
}
