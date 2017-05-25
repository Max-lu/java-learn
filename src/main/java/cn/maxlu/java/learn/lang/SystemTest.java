package cn.maxlu.java.learn.lang;

import org.junit.Test;

/**
 * Created by luwei on 2017/4/12.
 */
public class SystemTest {
    @Test
    public void nanoTimeTest() throws InterruptedException {
        //nanoTime只能用于计算时间间隔，不与任何时钟时间相关
        //毫微秒级别（即纳秒）
        long l1 = System.nanoTime();
        Thread.sleep(1000);
        long l2 = System.nanoTime();
        System.out.println(String.format("cost time: %s second(s)", (l2 - l1) / Math.pow(10, 9)));
    }
}
