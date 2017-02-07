package java8;

import reflect.Student;

import java.util.function.Supplier;

/**
 * Created by max.lu on 2016/1/27.
 */
public class Test2 {
    public static void main(String[] args) {
        method1();
    }

    private static void method1() {
        Student student1 = new Student();

        Supplier<Student> student2 = Student::new;
    }
}
