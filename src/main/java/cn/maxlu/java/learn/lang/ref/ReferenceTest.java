package cn.maxlu.java.learn.lang.ref;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created by luwei on 2017/5/23.
 */
public class ReferenceTest {
    public static void main(String[] args) {
        Student a = new Student();//强引用
        SoftReference<Student> softReference = new SoftReference<>(a);//软引用
        WeakReference<Student> weakReference = new WeakReference<>(a);//弱引用

        System.out.println(String.format("strong=%s, soft=%s, weak=%s", a, softReference.get(), weakReference.get()));

        a = null;//移除强引用，对象变为软引用
        System.out.println(String.format("strong=%s, soft=%s, weak=%s", a, softReference.get(), weakReference.get()));

        softReference.clear();//移除软引用，对象变为弱引用
        System.gc(); //执行GC，只剩余弱引用的对象将被回收
        System.out.println(String.format("strong=%s, soft=%s, weak=%s", a, softReference.get(), weakReference.get()));
    }
}
