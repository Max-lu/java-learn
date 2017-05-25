package cn.maxlu.java.learn.io.serializable.custom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ser();
    }

    private static void dser() throws IOException, ClassNotFoundException {
        File file = new File("E:\\test\\test.txt");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Person2 person = (Person2) in.readObject();
        System.out.println(person);
    }

    private static void ser() throws IOException {
        File file = new File("E:\\test\\test.txt");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        Person2 person = new Person2();
        person.setName("max");
        person.setAge(23);
        person.setSex("male");
        out.writeObject(person);
    }
}
