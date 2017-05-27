package cn.maxlu.java.learn.util.concurrent.queue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by luwei on 2017/5/27.
 */
public class DelayQueueTest {
    public static void main(String[] args) throws Exception {
        DelayQueue<Delayed> queue = new DelayQueue<>();
        queue.put(new MyDelayElement(10));

        Delayed ele = queue.take();

        System.out.println(ele);
    }

    private static class MyDelayElement implements Delayed {

        private static final TimeUnit DEFAULT_TIME_UNIT = TimeUnit.SECONDS;

        private long time;

        MyDelayElement(long time, TimeUnit timeUnit) {
            this.time = TimeUnit.MILLISECONDS.convert(time, timeUnit) + System.currentTimeMillis();
        }

        MyDelayElement(long time) {
            this(time, DEFAULT_TIME_UNIT);
        }

        @Override
        public long getDelay(TimeUnit unit) {
            System.out.println("get delay");
            return unit.convert(time - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return Long.compare(o.getDelay(TimeUnit.SECONDS), this.getDelay(TimeUnit.SECONDS));
        }
    }
}
