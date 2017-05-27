package cn.maxlu.java.learn.util.concurrent.forkjoinpool;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by luwei on 2017/5/27.
 */
public class RecursiveTaskTest {

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);

        MyRecursiveTask myRecursiveTask = new MyRecursiveTask(24);

        Integer result = forkJoinPool.invoke(myRecursiveTask);

        Assert.assertEquals(result, Integer.valueOf(24));
    }

    private static class MyRecursiveTask extends RecursiveTask<Integer> {

        private int threshold;

        MyRecursiveTask(int threshold) {
            this.threshold = threshold;
        }
        @Override
        protected Integer compute() {
            if (threshold > 4) {
                int result = 0;

                //创建子任务
                List<RecursiveTask<Integer>> tasks = new ArrayList<>();
                for (int i = 0; i < 2; i++) {
                    MyRecursiveTask subTask = new MyRecursiveTask(threshold / 2);
                    tasks.add(subTask);
                }

                //执行子任务
                tasks.forEach(ForkJoinTask::fork);

                ///获得子任务返回结果
                for (RecursiveTask task : tasks) {
                    Object join = task.join(); //FIXME 为什么返回的类型是Object？？
                    result += (int)(task.join());
                }
                return result;
            } else {
                System.out.println(Thread.currentThread().getName() + " do it myself:" + threshold);
                return threshold;
            }
        }
    }
}
