package cn.maxlu.java.learn.basic.generics;

public class Path<T> {

    <D> Path<D> get() {
        return new Path<>();
    }

}
