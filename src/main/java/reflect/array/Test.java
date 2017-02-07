package reflect.array;

import reflect.Student;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by max.lu on 2016/1/26.
 */
public class Test {

    public static void main(String[] args) {
        Student student = new Student();
        student.setAge(111);
        student.setId(1);
        student.setName("max111");


        Object object = Array.newInstance(Student.class, 3);

        int[] x = {3};
        Object object1 = Array.newInstance(Student.class, x);
        Array.set(object1, 0, student);

        Student[] students = (Student[])object1;
        System.out.println(Arrays.toString(students));


        System.out.println(object1.getClass().isArray());

        String[] array = new String[20];
        Array.set(array, 0, "max");
        System.out.println(Arrays.toString(array));
    }
}
