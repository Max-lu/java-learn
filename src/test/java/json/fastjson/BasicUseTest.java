package json.fastjson;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luwei on 2017/4/7.
 */
public class BasicUseTest {
    @Test
    public void toJson() {
        Student stu = new Student("luwei", 18);
        String s1 = JSON.toJSONString(stu);
        String s2 = JSON.toJSONString(stu, true);
        System.out.println(s1);
        System.out.println(s2);

        Object o1 = JSON.toJSON(stu);
        System.out.println(o1);

        List<Student> stus = new ArrayList<>();
        stus.add(new Student("luwei", 18));
        stus.add(new Student("luwei", 19));
        Object o2 = JSON.toJSON(stus);
        System.out.println(o2);

    }
}
