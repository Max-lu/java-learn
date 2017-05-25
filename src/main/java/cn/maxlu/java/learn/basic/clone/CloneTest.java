package cn.maxlu.java.learn.basic.clone;

import java.io.IOException;

/**
 * Created by max.lu on 2016/2/2.
 */
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        shallowCopyTest();
        deepCopyTest();
        deepCopyTest2();
    }


    private static void shallowCopyTest() throws CloneNotSupportedException {
        System.out.println("---shallow clone---");
        StudentShallowCopy studentShallowCopy1 = new StudentShallowCopy();
        studentShallowCopy1.setName("student1");
        studentShallowCopy1.setTeacher(new Teacher("teacher1"));
        System.out.println(String.format("before:1-->student:%s teacher:%s", studentShallowCopy1.getName(), studentShallowCopy1.getTeacher().getName()));

        StudentShallowCopy studentShallowCopy2 = (StudentShallowCopy) studentShallowCopy1.clone();
        studentShallowCopy2.setName("student2");
        studentShallowCopy2.getTeacher().setName("teacher2");

        System.out.println(String.format("after:1->student:%s teacher:%s", studentShallowCopy1.getName(), studentShallowCopy1.getTeacher().getName()));
        System.out.println(String.format("after:2->student:%s teacher:%s", studentShallowCopy2.getName(), studentShallowCopy2.getTeacher().getName()));

    }

    private static void deepCopyTest() throws CloneNotSupportedException {
        System.out.println("---deep clone---");
        StudentDeepCopy studentDeepCopy1 = new StudentDeepCopy();
        studentDeepCopy1.setName("student1");
        studentDeepCopy1.setTeacher(new Teacher("teacher1"));
        System.out.println(String.format("before:1->student:%s teacher:%s", studentDeepCopy1.getName(), studentDeepCopy1.getTeacher().getName()));

        StudentDeepCopy studentDeepCopy2 = (StudentDeepCopy) studentDeepCopy1.clone();
        studentDeepCopy2.setName("student2");
        studentDeepCopy2.getTeacher().setName("teacher2");

        System.out.println(String.format("after:1->student:%s teacher:%s", studentDeepCopy1.getName(), studentDeepCopy1.getTeacher().getName()));
        System.out.println(String.format("after:2->student:%s teacher:%s", studentDeepCopy2.getName(), studentDeepCopy2.getTeacher().getName()));
    }

    private static void deepCopyTest2() throws IOException, CloneNotSupportedException, ClassNotFoundException {
        System.out.println("---deep copy2---");
        StudentSerial student1 = new StudentSerial();
        student1.setName("student1");
        student1.setTeacher(new TeacherSerial("teacher1"));
        System.out.println(String.format("before:1->student:%s teacher:%s", student1.getName(), student1.getTeacher().getName()));

        StudentSerial student2 = (StudentSerial) student1.deepClone();
        student2.setName("student2");
        student2.getTeacher().setName("teacher2");

        System.out.println(String.format("after:1->student:%s teacher:%s", student1.getName(), student1.getTeacher().getName()));
        System.out.println(String.format("after:2->student:%s teacher:%s", student2.getName(), student2.getTeacher().getName()));
    }
}
