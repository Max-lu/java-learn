package cn.maxlu.java.learn.basic;

import java.io.*;

/**
 * Created by lw on 2016/10/23.
 */

/**
 * 五种实例化方式
 */
public class FiveWayOfInstantiationTest {
    public static void main(String[] args) throws Exception {
        Person p1 = new Person();
        Person p2 = Person.class.newInstance();
        Person p3 = Person.class.getConstructor().newInstance();
        Person p4 = (Person) p1.clone();

        new ObjectOutputStream(new FileOutputStream("data/data.obj")).writeObject(p1);
        Person p5 = (Person) new ObjectInputStream(new FileInputStream("data/data.obj")).readObject();

        System.out.println("------------------");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);

    }

    private static class Person implements Cloneable, Serializable {


        private static final long serialVersionUID = -5437436730032433428L;

        private Integer id;
        private String name;
        private Integer age;


        public Person() {
            System.out.println("call constructor");
        }

        public Person(Integer id, String name, Integer age ) {
            this.id = id;
            this.age =age;
            this.name = name;
        }
        public Integer getId() {
            return id;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        @Override
        public Object clone() {
            try {
                return super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
