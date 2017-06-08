package cn.maxlu.java.learn.lang.thread.shutdown;

/**
 * Created by luwei on 2017/6/7.
 */
public class ShutdownThreadTest {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();

        Thread.sleep(2 * 1000);

        myThread.shutdown();
        myThread.join();
    }

    private static class MyThread extends Thread {

        private volatile boolean isInterrupt = false;

        @Override
        public void run() {
            try {
                while (!isInterrupt) {
                    synchronized (this) {
                        wait();
                    }
                }
            } catch (InterruptedException e) {
                isInterrupt = true;
            }
        }

        void shutdown() {
            this.interrupt();
        }
    }
}
