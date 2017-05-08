package annotation.lombok;

import java.lang.reflect.Method;

/**
 * Created by luwei on 2017/5/8.
 */
public class LombokTest {
    public static void main(String[] args) {
        Person person = new Person();
        Method[] methods = person.getClass().getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}
