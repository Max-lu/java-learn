package cn.maxlu.java.learn.util.concurrent.queue.basic.usage;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by luwei on 2017/5/27.
 */
public class ProducerConsumerTest {
    public static void main(String[] args) throws Exception {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        producer.start();

        Thread.sleep(2 * 1000);

        consumer.start();
    }
}
