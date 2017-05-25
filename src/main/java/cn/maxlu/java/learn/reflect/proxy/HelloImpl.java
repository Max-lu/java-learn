package cn.maxlu.java.learn.reflect.proxy;

/**
 * Created by max.lu on 2016/1/26.
 */
public class HelloImpl implements Hello {
    @Override
    public void say() {
        System.out.println("Hello World!");
    }
}
