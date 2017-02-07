import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by lw on 2016/10/23.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Person p1 = new Person();
        Person p2 = Person.class.newInstance();
        Person p3 = Person.class.getConstructor().newInstance();
        Person p4 = (Person) p1.clone();

        new ObjectOutputStream(new FileOutputStream("e:\\data.obj")).writeObject(p1);
        Person p5 = (Person) new ObjectInputStream(new FileInputStream("e:\\data.obj")).readObject();

        System.out.println("------------------");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);

    }
}
