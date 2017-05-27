package cn.maxlu.java.learn.util.concurrent.forkjoinpool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Created by luwei on 2017/5/27.
 */
public class RecursiveActionTest {

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);

        MyRecursiveAction myRecursiveAction = new MyRecursiveAction(24);

        forkJoinPool.invoke(myRecursiveAction);
    }

    private static class MyRecursiveAction extends RecursiveAction {

        private int threshold;

        MyRecursiveAction(int threshold) {
            this.threshold = threshold;
        }

        @Override
        protected void compute() {
            if (threshold > 16) {
                for (int i = 0; i < 2; i++) {
                    MyRecursiveAction subTask = new MyRecursiveAction(threshold / 2);
                    subTask.fork();
                }
            } else {
                System.out.println("do it myself:" + threshold);
            }
        }
    }
}
