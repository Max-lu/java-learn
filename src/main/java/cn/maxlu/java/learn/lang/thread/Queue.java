package cn.maxlu.java.learn.lang.thread;

/**
 * Created by max.lu on 2016/3/2.
 */
public class Queue {

    private int valueCount = 0;
    private boolean isEmpty = true;

    public synchronized void put(int i) {
        if (valueCount == 5) {
            try {
                System.out.println("producer wait...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        valueCount++;
        System.out.println("producer work, left " + valueCount);
        isEmpty = false;
        notify();
    }

    public synchronized void get() {
        if (isEmpty) {
            try {
                System.out.println("consumer wait...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        valueCount--;
        System.out.println("consumer work, left " + valueCount);
        if (valueCount < 1) {
            isEmpty = true;
        }
        notify();
    }

}
