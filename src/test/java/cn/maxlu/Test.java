package cn.maxlu;
/**
 * Created by lw on 2016/7/18.
 */
public abstract class Test {
    public int a = 0;

    public static void main(String[] args) {
        ClassLoader classLoader = Object.class.getClassLoader();
        System.out.println(classLoader);

        Object object = new Object();
        ClassLoader classLoader2 = object.getClass().getClassLoader();
        System.out.println(classLoader2);

        System.out.println(Test.class.getClassLoader());


        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);

        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader);
    }
}
