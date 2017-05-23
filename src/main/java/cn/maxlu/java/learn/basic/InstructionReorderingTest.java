package cn.maxlu.java.learn.basic;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by lw on 2016/7/18.
 */

/**
 * 指令重排序测试
 */
public class InstructionReorderingTest {

    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10000; i++) {

            CountDownLatch latch = new CountDownLatch(1);

            InstructionReorderingTest test = new InstructionReorderingTest();
            Callable<Void> callable1 = () -> {
                latch.await();
                System.out.println(test.getValue());
                return null;
            };
            Callable<Void> callable2 = () -> {
                latch.await();
                test.init();
                return null;
            };

            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    latch.countDown();
                }
            }.start();

            List<Future<Void>> futures = service.invokeAll(Arrays.asList(callable2, callable1));
        }

        Thread.sleep(2 * 1000);
        service.shutdown();
    }


    private boolean isInit = false;

    private int value = 0;

    /**
     * 由于指令重排序，语句2可能比语句1先执行
     * 多线程状态下如果getValue动作发生在语句1和2之间，则getValue方法可能返回0
     */
    private void init() {
        value = 1; //1
        isInit = true; //2
    }

    private int getValue() {
        if (isInit) {
            return value;
        } else {
            return -1;
        }
    }

}
