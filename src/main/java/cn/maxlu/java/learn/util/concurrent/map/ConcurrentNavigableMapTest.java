package cn.maxlu.java.learn.util.concurrent.map;

import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by luwei on 2017/5/27.
 */
public class ConcurrentNavigableMapTest {
    public static void main(String[] args) {
        ConcurrentNavigableMap<String, Object> map = new ConcurrentSkipListMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");

        ConcurrentNavigableMap<String, Object> headMap = map.headMap("3");
        ConcurrentNavigableMap<String, Object> tailMap = map.tailMap("3");

        ConcurrentNavigableMap<String, Object> subMap = map.subMap("2", "3");

        System.out.println(headMap);
        System.out.println(tailMap);
        System.out.println(subMap);
    }
}
