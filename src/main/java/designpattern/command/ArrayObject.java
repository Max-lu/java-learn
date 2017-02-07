package designpattern.command;

public class ArrayObject {

    private String[] target;

    public void doHandler(Command command) {
        command.handler(target);
    }

    public String[] getTarget() {
        return target;
    }

    public void setTarget(String[] target) {
        this.target = target;
    }
}
