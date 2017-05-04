package cn.maxlu.ijava.util.map.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by luwei on 2017/5/3.
 */
public class HashConflictTest {
    public static void main(String[] args) {
        Map<MapKey, String> map = new HashMap<>();

        MapKey k1 = new MapKey();
        MapKey k2 = new MapKey();
        map.put(k1, "v1");
        map.put(k2, "v2");

        String v2 = map.get(k2);
        System.out.println(v2);
    }
}
