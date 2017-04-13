package cn.maxlu.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Created by max.lu on 2016/1/27.
 */
public class Test {
    public static void main(String[] args) {
        test("loop");
        test("list");
        test("set");
    }

    private static void test(String method) {
        long startTime = System.nanoTime();
        for (int i = 0; i < 10000000; i++) {
            run(method);
        }
        long endTime = System.nanoTime();
        System.out.println(method + " cost:" + (endTime - startTime) / 1000 + " ms");
    }

    private static void run(String method) {
        String[] letter = {"ab", "cd", "ef", "gh"};
        String target = "ij";
        if (Objects.equals("loop", method)) {
            useLoop(letter, target);
        }
        if (Objects.equals("list", method)) {
            useList(letter, target);
        }
        if (Objects.equals("set", method)) {
            useSet(letter, target);
        }
    }

    private static boolean useLoop(String[] letter, String target) {
        for (String s : letter) {
            if (Objects.equals(s, target)) {
                return true;
            }
        }
        return false;
    }

    private static boolean useSet(String[] letter, String target) {
        Set<String> set = new HashSet<>(Arrays.asList(letter));
        return set.contains(target);
    }

    private static boolean useList(String[] letter, String target) {
        List<String> list = Arrays.asList(letter);
        return list.contains(target);
    }
}
