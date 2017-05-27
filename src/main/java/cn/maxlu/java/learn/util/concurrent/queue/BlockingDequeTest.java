package cn.maxlu.java.learn.util.concurrent.queue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by luwei on 2017/5/27.
 */
public class BlockingDequeTest {
    public static void main(String[] args) throws Exception {
        BlockingDeque<String> deque = new LinkedBlockingDeque<>();
        deque.putFirst("hello");
        deque.putLast("world");

        String first = deque.takeFirst();
        String last = deque.takeLast();

        System.out.println(first);
        System.out.println(last);
    }


}
