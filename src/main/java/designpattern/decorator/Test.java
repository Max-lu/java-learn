package designpattern.decorator;

public class Test {

    public static void main(String[] args) {
        Decorator decorator = new Decorator(new ComponentImpl());
        decorator.say();
    }
}
