package java8;

import reflect.Student;

import java.util.Random;
import java.util.function.Supplier;

/**
 * Created by max.lu on 2016/1/27.
 */
public class StudentSupplier implements Supplier<Student> {
    private int index = 0;
    private Supplier<Random> random = Random::new;

    @Override
    public Student get() {
        return new Student(index++, "max1", random.get().nextInt(20));
    }
}
