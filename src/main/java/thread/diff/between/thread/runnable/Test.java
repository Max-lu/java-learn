package thread.diff.between.thread.runnable;

/**
 * Created by luwei on 2017/5/8.
 */
class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new MyThread1();
        Thread thread2 = new MyThread1();
        Thread thread3 = new MyThread1();

//        Thread thread = new MyThread1();
//        Thread thread1 = new Thread(thread);
//        Thread thread2 = new Thread(thread);
//        Thread thread3 = new Thread(thread);

        Runnable myRunnable = new MyRunnable();
        Thread thread4 = new Thread(myRunnable);
        Thread thread5 = new Thread(myRunnable);
        Thread thread6 = new Thread(myRunnable);

        thread1.start();
        thread2.start();
        thread3.start();

        Thread.sleep(1000);

        thread4.start();
        thread5.start();
        thread6.start();

        Thread.sleep(1000);
    }

    private static class MyThread1 extends Thread {
        private int num = 0;
        @Override
        public void run() {
            System.out.println("thread extends Thread-" + num++);
        }
    }

    private static class MyRunnable implements Runnable {
        private int num = 0;
        @Override
        public void run() {
            System.out.println("thread implements Runnable-" + num++);
        }
    }
}
