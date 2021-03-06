package cn.maxlu.java.learn.lang.thread;

/**
 * Created by max.lu on 2016/3/2.
 */
public class DeadLock extends Thread{
    // important static
    private static final Object A = new Object();
    private static final Object B = new Object();
    private static boolean flag = true;

    public static void main(String[] args) {
        Thread thread1 = new DeadLock();
        Thread thread2 = new DeadLock();
        thread1.start();
        thread2.start();
    }

    public void accessA() {
        flag = false;
        synchronized (A) {
            System.out.println(this.getName() + ";get cn.maxlu.A");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + ";wait cn.maxlu.B");
            synchronized (B) {
                System.out.println(this.getName() + ";get cn.maxlu.B");
            }
        }

    }

    public void accessB() {
        flag = true;
        synchronized (B) {
            System.out.println(this.getName() + ";get cn.maxlu.B");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + ";wait cn.maxlu.A");
            synchronized (A) {
                System.out.println(this.getName() + ";get cn.maxlu.A");
            }
        }

    }


    @Override
    public void run() {
        if (flag) {
            accessA();
        } else {
            accessB();
        }
    }
}
