package cn.maxlu.java.learn.util.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by luwei on 2017/5/16.
 */
public class Student implements Observer {

    private String name;

    Student(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        Teacher teacher = (Teacher) o;
        System.out.println(String.format("%s : teacher %s ask a question: %s", this.name, teacher.getName(), arg));
    }
}
