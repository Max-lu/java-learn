package cn.maxlu.java.learn.lang.thread;

/**
 * Created by luwei on 2017/5/25.
 */
public class JoinTest {

    public static void main(String[] args) throws Exception {

        Thread thread = Thread.currentThread();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                for (;;) {
                    try {
                        Thread.sleep(2 * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(thread.getState() + ":" + thread1.getState());
                }
            }
        };

        thread1.start();
        thread2.start();

        thread1.join();
    }


}
