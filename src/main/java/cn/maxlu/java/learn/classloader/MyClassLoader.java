package cn.maxlu.java.learn.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by luwei on 2017/4/13.
 */
public class MyClassLoader extends ClassLoader {

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return this.loadClass(name, false);
    }

    @Override
    public Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class klass = null;
        try {
            klass = findLoadedClass(name);
            if (klass != null) {
                return klass;
            }

            byte[] bs = getClassBytes(name);
            if (bs != null && bs.length > 0) {
                klass = defineClass(name, bs, 0, bs.length);
            }
            if (klass == null) {
                klass = findSystemClass(name);
            }
            if (resolve && klass != null) {
                resolveClass(klass);
            }
        } catch (IOException e) {
            throw new ClassNotFoundException(e.toString());
        }
        System.out.println("klass == " + klass);
        return klass;
    }

    private byte[] getClassBytes(String className) throws IOException {
        String path = System.getProperty("java.class.path") + File.separator;
        path += className.replace('.', File.separatorChar) + ".class";
        System.out.println(path);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        byte[] bs = new byte[fis.available()];
        fis.read(bs);
        return bs;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class klass = null;
        try {
            klass = findLoadedClass(name);
            if (klass != null) {
                return klass;
            }

            byte[] bs = getClassBytes(name);
            if (bs != null && bs.length > 0) {
                klass = defineClass(name, bs, 0, bs.length);
            }
            if (klass == null) {
                klass = findSystemClass(name);
            }
        } catch (IOException e) {
            throw new ClassNotFoundException(e.toString());
        }
        System.out.println("klass == " + klass);
        return klass;
    }
}
