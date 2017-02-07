package designpattern.observer;

public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        Observer observer1 = new Observer1();
        Observer observer2 = new Observer2();
        person.register(observer1);
        person.register(observer2);
        person.setName("max");
        person.setAge(19);
    }
}
