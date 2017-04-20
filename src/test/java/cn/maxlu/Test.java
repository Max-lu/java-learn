package cn.maxlu;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by lw on 2016/7/18.
 */
public class Test {

    public Test(int a) {
        this.a = a;
    }

    public Test() {
        new Test(1);
    }

    public int a = 0;

    public static void main(String[] args) throws InterruptedException {
        StringBuilder sb1 = new StringBuilder();
        StringBuffer sb2 = new StringBuffer();

        ExecutorService service = Executors.newFixedThreadPool(100);
        List<Callable<Void>> tasks = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            tasks.add(() -> {
                sb1.append(finalI).append('-');
                sb2.append(finalI).append('-');
                return null;
            });
        }

        List<Future<Void>> futures = service.invokeAll(tasks);

        System.out.println(sb1.toString());
        System.out.println(sb2.toString());

    }
}
