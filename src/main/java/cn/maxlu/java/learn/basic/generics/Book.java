package cn.maxlu.java.learn.basic.generics;

/**
 * Created by max.lu on 2016/2/2.
 */
class Book<T> {
    private T attr;

    T getAttr() {
        return attr;
    }

    void setAttr(T attr) {
        this.attr = attr;
    }
}
