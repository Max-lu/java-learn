package cn.maxlu.java8.stream;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by max.lu on 2016/3/14.
 */
public class Test3 {
    public static void main(String[] args) throws Exception {
        m1();
    }

    private static void m1() throws Exception {
        int processors = Runtime.getRuntime().availableProcessors();
        String contents = new String(Files.readAllBytes(Paths.get(new URI("file:///D:/my_project/Test/src/java8/test.txt"))), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
        for (int i = 0; i < processors; i++) {
            Runnable runnable = () -> System.out.println("ss");
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}
