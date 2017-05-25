package cn.maxlu.java.learn.lang.thread;

/**
 * Created by max.lu on 2016/3/2.
 */
public class ThreadDemo1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
