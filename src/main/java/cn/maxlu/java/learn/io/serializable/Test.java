package cn.maxlu.java.learn.io.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Object[] objects = {new Person("max1", 1), new Person("max2", 2)};
        ser2(objects);
        dser2();
    }

    private static void dser2() throws IOException, ClassNotFoundException {
        File file = new File("E:\\test\\test.txt");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Object[] objects = (Object[]) in.readObject();
        for (Object object : objects) {
            Person person = (Person) object;
            System.out.println(person);
        }
    }

    private static void ser2(Object[] objects) throws IOException {
        File file = new File("E:\\test\\test.txt");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(objects);
    }

    private static void dser() throws IOException, ClassNotFoundException {
        File file = new File("E:\\test\\test.txt");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Person person = (Person) in.readObject();
        System.out.println(person);
    }

    private static void ser() throws IOException {
        File file = new File("E:\\test\\test.txt");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        Person person = new Person();
        person.setName("max");
        person.setAge(23);
        out.writeObject(person);
    }
}
