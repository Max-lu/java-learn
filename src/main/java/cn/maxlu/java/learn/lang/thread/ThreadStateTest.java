package cn.maxlu.java.learn.lang.thread;

/**
 * Created by luwei on 2017/5/25.
 */
public class ThreadStateTest {

    private static final Object lock = new Object();

    public static void main(String[] args) throws Exception {

        Thread thread = new Thread() {
            @Override
            public void run() {
                State state = Thread.currentThread().getState();

                assert state == State.RUNNABLE;
                System.out.println(state);

                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    synchronized (this) {
                        wait();
                    }
                } catch (InterruptedException e) {
                    //当前线程在等待一个monitor lock
                    synchronized (lock) {

                    }
                }
            }
        };

        assert thread.getState() == Thread.State.NEW;
        System.out.println(thread.getState());

        thread.start();

        Thread.sleep(200);
        assert thread.getState() == Thread.State.TIMED_WAITING;
        System.out.println(thread.getState());

        Thread.sleep(2 * 1000);
        assert thread.getState() == Thread.State.WAITING;
        System.out.println(thread.getState());

        synchronized (lock) {
            thread.interrupt();
            Thread.sleep(200);
            assert thread.getState() == Thread.State.BLOCKED;
            System.out.println(thread.getState());
        }

        Thread.sleep(2 * 1000);
        assert thread.getState() == Thread.State.TERMINATED;
        System.out.println(thread.getState());

        Thread.sleep(5 * 1000);
    }

}
