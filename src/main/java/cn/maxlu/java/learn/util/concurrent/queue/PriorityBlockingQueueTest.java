package cn.maxlu.java.learn.util.concurrent.queue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by luwei on 2017/5/27.
 */
public class PriorityBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        implComparable();
        notImplComparable();
    }

    private static void notImplComparable() throws InterruptedException {
        PriorityBlockingQueue<ClassNotImplComparable> queue = new PriorityBlockingQueue<>();
        queue.put(new ClassNotImplComparable(1));
        queue.put(new ClassNotImplComparable(3));
        queue.put(new ClassNotImplComparable(4));
        queue.put(new ClassNotImplComparable(2));
        queue.put(new ClassNotImplComparable(8));

        for (int i = 0; i < 5; i++) {
            System.out.println(queue.take().getI());
        }
    }

    private static void implComparable() throws InterruptedException {
        //Integer implements java.lang.Comparable
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();
        queue.put(5);
        queue.put(4);
        queue.put(2);
        queue.put(8);
        queue.put(1);

        for (int i = 0; i < 5; i++) {
            System.out.println(queue.take());
        }
    }

    private static class ClassNotImplComparable {
        private int i;

        ClassNotImplComparable(int i) {
            this.i = i;
        }

        public int getI() {
            return i;
        }
    }
}
