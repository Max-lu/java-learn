package io.serializable;

import java.io.Serializable;

public class Person implements Serializable {

    public Person(){

    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    private static final long serialVersionUID = -7255339907778771702L;
    private String name;
    private int age;
    //don not serializable this field
//    private transient int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name=" + this.name + ",age=" + this.age;
    }
}
