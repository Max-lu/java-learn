package cn.maxlu.java.learn.util.concurrent.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by luwei on 2017/5/27.
 */
public class LinkedBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<String> unbound = new LinkedBlockingQueue<>();

        LinkedBlockingQueue<String> bound = new LinkedBlockingQueue<>(20);
        bound.put("hello");

        String take = bound.take();
        System.out.println(take);
    }
}
