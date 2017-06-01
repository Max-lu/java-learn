package cn.maxlu.java.learn.lang.thread;

/**
 * Created by luwei on 2017/5/25.
 */
public class ExceptionHandlerTest {

    public static void main(String[] args) throws Exception {

        try {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    throw new RuntimeException("test");
                }
            };

            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread t, Throwable e) {
                    System.out.println("catch exception 1");
                }
            });

            thread.start();
        } catch (Throwable e) {
            System.out.println("catch exception 2"); //unable to catch exception of thread
        }
    }


}
