package java8;

import reflect.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by max.lu on 2016/1/27.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        method1();
        method2();
        method3();
        method4();
        method5();
        method6();
        method7();
        method8();
        method9();
        method10();
        method11();
        method12();
        method13();
        method14();
        method15();
        method16();
        method17();
        method18();
    }

    public static void method1() {
        String[] a = {"a", "b", "c"};
        List<String> collect = Arrays.asList(a).stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(Arrays.toString(collect.toArray()));
    }

    private static void method2() {
        Stream<List<Integer>> input = Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6));
        //System.out.println(Arrays.toString(input.toArray()));
        Stream<Integer> output = input.flatMap(Collection::stream);
        System.out.println(Arrays.toString(output.toArray()));
    }

    private static void method3() {
        Integer[] number1 = {1, 2, 3, 4, 5, 6};
        Integer[] number2 = Stream.of(number1).filter(a -> a % 2 == 0).toArray(Integer[]::new);
//        List<String> number3 = Stream.of(number1).filter(a -> a % 2 == 0).map(Integer::toString).collect(Collectors.toList());
        List<String> number3 = Stream.of(number1).filter(a -> a % 2 == 0).map(Object::toString).collect(Collectors.toList());
        System.out.println(Arrays.toString(number2));
        System.out.println(Arrays.toString(number3.toArray()));
    }

    private static void method4() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("D:\\learning\\Test\\src\\java8\\test.txt"));
        List<String> list = reader.lines().flatMap(line -> Stream.of(line.split(" "))).filter(word -> word.length() > 0).collect(Collectors.toList());
        reader.close();
        System.out.println(Arrays.toString(list.toArray()));
    }

    private static void method5() {
        Integer[] number1 = {1, 2, 3, 4, 5, 6};
        Stream.of(number1).filter(a -> a > 2).forEach(System.out::print);
        System.out.println();
        Arrays.asList(number1).parallelStream().filter(a -> a > 2).forEach(System.out::print);
        System.out.println();
    }

    private static void method6() {
        Integer[] number1 = {1, 2, 3, 4, 5, 6};
        List<Integer> list = Stream.of(number1).filter(a -> a > 2).peek(System.out::print).map(n -> n + 3).peek(System.out::print).collect(Collectors.toList());
        System.out.println();
        System.out.println(Arrays.toString(list.toArray()));
    }

    private static void method_() {
        final int[] c = {1};
        Integer[] number1 = {1, 2, 3, 4, 5, 6};
        Stream.of(number1).filter(a -> a > 2).forEach(b -> {
            b += c[0];
            c[0] = 2;
        });
        //forEach 不能修改自己包含的本地变量值，也不能用 break/return 之类的关键字提前结束循环。
//        int c = 1;
//        Integer[] number1 = {1, 2, 3, 4, 5, 6};
//        Stream.of(number1).filter(a -> a > 2).forEach(b -> {
//            b = b + c;
//            c= 2;
//        });
    }

    private static void method7() {
        String text1 = "22";
        String text2 = null;
        Optional.empty();
        Optional.ofNullable(text1).ifPresent(System.out::println);
        Optional.ofNullable(text2).ifPresent(System.out::println);
        Integer len1 = Optional.ofNullable(text1).map(String::length).orElse(-1);
        Integer len2 = Optional.ofNullable(text2).map(String::length).orElse(-1);
        System.out.println(len1);
        System.out.println(len2);

        Integer[] number1 = {1, 2, 3, 4, 5, 6};
        int num = Stream.of(number1).filter(a -> a > 4).findAny().orElse(-1);
        System.out.println("num=" + num);
    }

    private static void method8() {
        System.out.println("--method8--");
        Integer[] number1 = {1, 2, 3, 4, 5, 6};
        int sum1 = Stream.of(number1).reduce(0, Integer::sum);
        int sum2 = Stream.of(number1).reduce(0, (a, b) -> a + b);
        System.out.println(sum1);
        System.out.println(sum2);

        int min = Stream.of(number1).min(Integer::min).get();
        int max = Stream.of(number1).max(Integer::max).get();
        System.out.println(min);
        System.out.println(max);

        String concat1 = Stream.of("a", "b", "c", "d").reduce("", String::concat);
        String concat2 = Stream.of("a", "b", "c", "d").reduce(String::concat).get();
        String concat3 = Stream.of("a", "b", "c", "d").filter(n -> n.compareTo("z") > 0).reduce("", String::concat);
        System.out.println(concat1);
        System.out.println(concat2);
        System.out.println(concat3);
//        double minValue1 = Stream.of(11.2, 22.3, 33, 4).reduce(Double.MAX_VALUE, Double::min);
        double minValue2 = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        System.out.println(minValue2);

        int sumValue1 = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        int sumValue2 = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        System.out.println(sumValue1);
        System.out.println(sumValue2);
    }

    private static void method9() {
        System.out.println("--method9--");
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            students.add(new Student(i, "name" + i, i));
        }
        List<String> list = students.stream().map(Student::getName).limit(10).skip(3).collect(Collectors.toList());
        System.out.println(list);
    }

    private static void method10() {
        System.out.println("--method10--");
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            students.add(new Student(i, "name" + i, i));
        }
        List<Student> list = students.stream().sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).limit(2).collect(Collectors.toList());
        System.out.println(list);
    }


    private static void method11() {
        System.out.println("--method11--");
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            students.add(new Student(i, "name" + i, i));
        }
        List<Student> list = students.stream().limit(2).sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).collect(Collectors.toList());
        System.out.println(list);
    }

    private static void method12() throws IOException {
        System.out.println("--method12--");
        BufferedReader reader = new BufferedReader(new FileReader("D:\\learning\\Test\\src\\java8\\test.txt"));
        int longest = reader.lines().map(String::length).max(Integer::max).get();
        reader.close();
        System.out.println(longest);

        BufferedReader reader2 = new BufferedReader(new FileReader("D:\\learning\\Test\\src\\java8\\test.txt"));
        int longest2 = reader2.lines().mapToInt(String::length).max().getAsInt();
        reader2.close();
        System.out.println(longest2);
    }

    private static void method13() throws IOException {
        System.out.println("--method13--");
        BufferedReader reader = new BufferedReader(new FileReader("D:\\learning\\Test\\src\\java8\\test.txt"));
        List<String> list = reader.lines().flatMap(line -> Stream.of(line.split(" "))).filter(word -> word.length() > 0).map(String::toUpperCase).distinct().sorted().collect(Collectors.toList());
        reader.close();
        System.out.println(list);
    }

    private static void method14() {
        System.out.println("--method14--");
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "name" + 1, 12));
        students.add(new Student(1, "name" + 1, 15));
        students.add(new Student(1, "name" + 1, 18));
        students.add(new Student(1, "name" + 1, 20));
        students.add(new Student(1, "name" + 1, 25));
        boolean isAnyAdult = students.stream().anyMatch(stu -> stu.getAge() >= 18);
        boolean isAllAdult = students.stream().allMatch(stu -> stu.getAge() >= 18);
        boolean isNoneAdult = students.stream().noneMatch(stu -> stu.getAge() >= 18);
        System.out.println("any adult:" + isAnyAdult);
        System.out.println("all adult:" + isAllAdult);
        System.out.println("none adult:" + isNoneAdult);
    }

    private static void method15() {
        System.out.println("--method15--");
        Random seed = new Random();
//        Supplier<Integer> random = seed.nextInt();
        Supplier<Integer> random = seed::nextInt;
        Stream.generate(random).limit(10).forEach(System.out::println);

        //?
        IntStream.generate(() -> (int) System.nanoTime() % 100).limit(10).forEach(System.out::println);

        Stream.generate(StudentSupplier::new).limit(10).map(stu -> stu.get().getAge()).forEach(System.out::println);
        Stream.generate(new StudentSupplier()).limit(10).map(Student::getAge).forEach(System.out::println);
    }

    private static void method16() {
        System.out.println("--method16--");
        Stream.iterate(0, n -> n + 3).limit(10).forEach(System.out::println);
    }

    private static void method17() {
        System.out.println("--method17--");
        Map<Integer, List<Student>> collect = Stream.generate(new StudentSupplier()).limit(20).collect(Collectors.groupingBy(Student::getAge));
        Iterator iterator = collect.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, List<Student>> next = (Map.Entry) iterator.next();
            System.out.println(next.getKey() + ":" + next.getValue().size());
        }

        Map<Boolean, List<Student>> collect2 = Stream.generate(new StudentSupplier()).limit(20).collect(Collectors.partitioningBy(s -> s.getAge() < 18));
        System.out.println("child:" + collect2.get(true).size());
        System.out.println("adult:" + collect2.get(false).size());
    }

    private static void method18() {
        System.out.println("--method18--");
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x)
                .summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());

    }
}
