package cn.maxlu.java.learn.reflect.proxy.my.v2;

import cn.maxlu.ijava.lang.reflect.proxy.my.DefaultServiceImpl;
import cn.maxlu.ijava.lang.reflect.proxy.my.IService;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by luwei on 2017/5/3.
 */
public class Proxy_v2 implements Serializable {

    private static final long serialVersionUID = -1L;

    public static Object newProxyInstance() throws Exception {
        String proxyStr = "package cn.maxlu.ijava.lang.reflect.proxy.my.v2;\n" +
                "\n" +
                "import cn.maxlu.ijava.lang.reflect.proxy.my.IService;\n" +
                "\n" +
                "public class Proxy implements IService {\n" +
                "\n" +
                "    private IService service;\n" +
                "\n" +
                "    public Proxy(IService service) {\n" +
                "        this.service = service;\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void print() {\n" +
                "        System.out.println(\"===exec before===\");\n" +
                "        service.print();\n" +
                "        System.out.println(\"===exec after===\");\n" +
                "    }\n" +
                "}";

        String userDir = System.getProperty("user.dir");
        File root = new File(userDir + "\\target\\mytest\\");
        File javaFile = new File(root, "cn\\maxlu\\ijava\\lang\\reflect\\proxy\\my\\v2\\Proxy.java");
        javaFile.getParentFile().mkdirs();

        IService proxy = null;
        try {
            //将字符串写入java文件
            FileWriter fw = new FileWriter(javaFile);
            fw.write(proxyStr);
            fw.close();

            //编译java文件为class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            compiler.run(null, null, null, javaFile.getPath());

            //加载class文件
            URL[] urls = new URL[] {root.toURI().toURL()};
            URLClassLoader ul = new URLClassLoader(urls);
            Class<?> c = ul.loadClass("cn.maxlu.ijava.lang.reflect.proxy.my.v2.Proxy");

            //实例化
            Constructor<?> constructor = c.getConstructor(IService.class);
            IService service = new DefaultServiceImpl();
            proxy = (IService)constructor.newInstance(service);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            File classFile = new File(root, "cn\\maxlu\\ijava\\lang\\reflect\\proxy\\my\\v2\\Proxy.class");
            javaFile.delete();
            classFile.delete();
        }

        return proxy;
    }
}
