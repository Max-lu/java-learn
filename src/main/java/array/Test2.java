package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Test2 {
    public static void main(String[] args) {
        String[] letter = {"ab", "cd", "ef", "gh"};
        List<String> list = Arrays.asList(letter);
        List<String> linkedList = new LinkedList<>(Arrays.asList(letter));
        Set<String> set = new HashSet<>(list);
        Set<String> linkedHashSet = new LinkedHashSet<>(list);

        String target = "ij";

        long startTime = System.nanoTime();
        for (int i = 0; i < 10000000; i++) {
            run(letter, target);
        }
        long endTime = System.nanoTime();
        System.out.println("cost:" + (endTime - startTime) / 1000 + " ms");

    }

    private static <T> void run(T letter, String target) {
        if (letter instanceof String[]) {

        }
    }
}
