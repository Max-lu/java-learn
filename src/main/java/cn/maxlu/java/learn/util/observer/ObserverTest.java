package cn.maxlu.java.learn.util.observer;

/**
 * Created by luwei on 2017/5/16.
 */
public class ObserverTest {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("jason");

        Student student1 = new Student("maria");
        Student student2 = new Student("jane");
        Student student3 = new Student("michael");
        Student student4 = new Student("kangkang");

        teacher.addObserver(student1);
        teacher.addObserver(student2);
        teacher.addObserver(student3);
        teacher.addObserver(student4);

        teacher.askQuestion("1+1=?");
    }
}
