import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by lw on 2016/7/18.
 */
public class Test {
    @org.junit.Test
    public void test1() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        String[] array = new String[0];
        String[] strings = list.toArray(array);
        Object[] objects = list.toArray();
        Collections.emptyList();
        System.out.println("success");
    }
}
