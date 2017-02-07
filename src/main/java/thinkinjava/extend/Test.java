package thinkinjava.extend;

/**
 * Created by max.lu on 2016/1/29.
 */
public class Test {
    public static void main(String[] args) {
        Man man = new Man();
        Woman woman = new Woman();
        Others others = new Others();
        call(man);
        call(woman);
        call(others);
    }

    public static void call(Person person) {
        person.say();
    }
}
