package cn.maxlu.java.learn.util.concurrent.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by luwei on 2017/5/27.
 */
public class SynchronousQueueTest {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<String> queue = new SynchronousQueue<>();

        PutThread putThread = new PutThread(queue);
        TakeThread takeThread = new TakeThread(queue);

        putThread.start();
        takeThread.start();

        Thread.sleep(5 * 1000);
        System.exit(0);
    }

    private static class PutThread extends Thread {

        BlockingQueue<String> queue;

        PutThread(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(2 * 1000);
                queue.put("hello");
                System.out.println("put a element");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private static class TakeThread extends Thread {

        BlockingQueue<String> queue;

        TakeThread(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                queue.take();
                System.err.println("take a element");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
