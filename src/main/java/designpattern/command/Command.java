package designpattern.command;

@FunctionalInterface
public interface Command {
    void handler(String[] target);
}
