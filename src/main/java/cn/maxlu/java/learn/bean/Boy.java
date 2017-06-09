package cn.maxlu.java.learn.bean;

/**
 * Created by luwei on 2017/6/9.
 */
public class Boy {

    public Boy(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Boy(String name, int age, boolean hasGirl) {
        this.name = name;
        this.age = age;
        this.hasGirl = hasGirl;
    }

    private String name;

    private int age;

    private boolean hasGirl;

    public boolean isHasGirl() {
        return hasGirl;
    }

    public void setHasGirl(boolean hasGirl) {
        this.hasGirl = hasGirl;
    }

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
}
