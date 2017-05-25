package cn.maxlu.java.learn.lang;

/**
 * Created by lw on 2016/7/18.
 */

public class DaemonThreadTest {

    //当正在运行的线程都是守护线程时，Java 虚拟机退出, 所有线程终止。
    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + " sleep 10 seconds");
                    Thread.sleep(10 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.setDaemon(true);

        Thread t2 = new Thread("t2") {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + " sleep 10 seconds");
                    Thread.sleep(10 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t2.setDaemon(true);


        t1.start();
        t2.start();
    }

}
