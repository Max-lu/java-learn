package designpattern.command;

public class Test {
    /**
     *different command different handler
     */
    public static void main(String[] args) {
        String[] array = {"a", "b", "c"};
        ArrayObject arrayObject = new ArrayObject();
        arrayObject.setTarget(array);

        //functional interfaces: x->f(x)
        // command 1
        arrayObject.doHandler(target -> {
            for (String s : target) {
                System.out.println(s);
            }
        });

        //command 2
        arrayObject.doHandler(target -> System.out.println(String.join(",", target)));
    }
}
