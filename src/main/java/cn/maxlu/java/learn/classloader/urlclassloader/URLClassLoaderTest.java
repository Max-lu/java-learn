package cn.maxlu.java.learn.classloader.urlclassloader;

import org.junit.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by luwei on 2017/5/5.
 */
public class URLClassLoaderTest {
    @Test
    /*
    * 使用示例
    */
    public void test() throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        File root = new File("/some/path");
        URL[] urls = new URL[] {root.toURI().toURL()};
        URLClassLoader ul = new URLClassLoader(urls);
        Class<?> c = ul.loadClass("fully.qualified.name.of.your.Clazz");
        //此时的Clazz.class文件的真实路径应该为/some/path/fully/qualified/name/of/your/Clazz.class
        Object o = c.newInstance();
    }
}
