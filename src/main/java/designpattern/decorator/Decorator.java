package designpattern.decorator;

public class Decorator implements Component {

    private Component decorator;

    public Decorator(Component component) {
        this.decorator = component;
    }
    @Override
    public void say() {
        System.out.println("before say...");
        this.decorator.say();
        System.out.println("after say...");
    }
}
