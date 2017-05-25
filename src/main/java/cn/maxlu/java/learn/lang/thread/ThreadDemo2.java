package cn.maxlu.java.learn.lang.thread;

/**
 * Created by max.lu on 2016/3/2.
 */
public class ThreadDemo2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            try {
                Thread.sleep(10);
                System.out.println("\t sleep...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
