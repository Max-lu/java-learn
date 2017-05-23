package cn.maxlu.java.learn.lang.ref.cache.impl;

/**
 * Created by luwei on 2017/5/23.
 */
public class User {

    public User(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
