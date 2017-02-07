package map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by max.lu on 2016/1/27.
 */
public class MapTest {

    private static Map<String, Object> map = new HashMap<>();
    static {
        map.put("a", "b");
    }
    public static void main(String[] args) {
        System.out.println(map);
    }
}
