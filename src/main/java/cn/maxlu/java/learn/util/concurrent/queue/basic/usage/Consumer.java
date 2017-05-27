package cn.maxlu.java.learn.util.concurrent.queue.basic.usage;

import java.util.concurrent.BlockingQueue;

/**
 * Created by luwei on 2017/5/27.
 */
public class Consumer extends Thread {

    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("take : " + queue.take());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
