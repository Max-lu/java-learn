package annotation;

/**
 * Created by max.lu on 2016/1/26.
 */
public class Test {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        HandleTestAnnotation.process("annotation.MyClass");
    }
}
