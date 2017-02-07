package java8;

import java.util.stream.Stream;

/**
 * Created by max.lu on 2016/3/11.
 */
public class Stream1 {
    public static void main(String[] args) {
        Object[] power = Stream.iterate(1.0, p -> p * 2).peek(System.out::println).limit(20).toArray();


    }
}
