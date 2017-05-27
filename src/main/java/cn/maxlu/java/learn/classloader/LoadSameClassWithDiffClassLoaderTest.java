package cn.maxlu.java.learn.classloader;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by luwei on 2017/5/25.
 */
public class LoadSameClassWithDiffClassLoaderTest {

    private static final String CLASS_TO_BE_LOAD = LoadSameClassWithDiffClassLoaderTest.class.getName();

    public static void main(String[] args) throws Exception {
        m1();
    }

    private static void m1() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        ClassLoader myClassLoader = new MyClassLoader();

        Object obj = myClassLoader.loadClass(CLASS_TO_BE_LOAD).newInstance();
        LoadSameClassWithDiffClassLoaderTest test = new LoadSameClassWithDiffClassLoaderTest();

        System.out.println(obj.getClass());
        System.out.println(test.getClass());

        System.out.println(obj.getClass().getClassLoader());
        System.out.println(test.getClass().getClassLoader());

        System.out.println(test.getClass() == obj.getClass());

        System.out.println(obj instanceof LoadSameClassWithDiffClassLoaderTest);
        System.out.println(test instanceof LoadSameClassWithDiffClassLoaderTest);
    }

    private static class MyClassLoader extends ClassLoader {
        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            //获取类文件名
            String filename = name.substring(name.lastIndexOf(".") + 1) + ".class";
            InputStream in = getClass().getResourceAsStream(filename);

            if (in == null) {
                throw new RuntimeException("Could not found class file:" + filename);
            }
            try {
                byte[] b = new byte[in.available()];
                int readLen = in.read(b);
                if (readLen == -1) {
                    return null;
                }
                return defineClass(name, b, 0, b.length);
            } catch (IOException e) {
                throw new ClassNotFoundException(name);
            }
        }

        @Override
        protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
            if (!CLASS_TO_BE_LOAD.equals(name)) {
                return super.loadClass(name, resolve);
            }
            Class<?> c = findLoadedClass(name);
            if (c == null) {
                c = findClass(name);
            }
            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
    }
}
