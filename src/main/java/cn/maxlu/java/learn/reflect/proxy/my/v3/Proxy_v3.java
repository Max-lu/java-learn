package cn.maxlu.java.learn.reflect.proxy.my.v3;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by luwei on 2017/5/3.
 */
class Proxy_v3 implements Serializable {

    private static final long serialVersionUID = -1L;

    static <T> T newProxyInstance(Class<T> clazz, InvokeHandler invokeHandler) throws Exception {

        String clazzName = clazz.getName();

        StringBuilder methodSb = new StringBuilder();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            methodSb.append("@Override\n");
            methodSb.append("public\t").append(method.getReturnType()).append("\t").append(method.getName());
            methodSb.append("(");

            Class<?>[] parameterTypes = method.getParameterTypes();
            int length = parameterTypes.length;
            for (int i = 0; i< length; i++) {
                String parameterTypeName = parameterTypes[i].getName();
                if (parameterTypeName.startsWith("[")) {
                    switch (parameterTypeName.substring(0, 2)) {
                        case "[L":
                            parameterTypeName = parameterTypeName.substring(2, parameterTypeName.length() - 1) + "[]";
                            break;
                        case "[Z":
                            parameterTypeName = "boolean[]";
                            break;
                        case "[B":
                            parameterTypeName = "byte[]";
                            break;
                        case "[S":
                            parameterTypeName = "short[]";
                            break;
                        case "[I":
                            parameterTypeName = "int[]";
                            break;
                        case "[J":
                            parameterTypeName = "long[]";
                            break;
                        case "[F":
                            parameterTypeName = "float[]";
                            break;
                        case "[D":
                            parameterTypeName = "double[]";
                            break;
                        case "[C":
                            parameterTypeName = "char[]";
                            break;
                        default:
                            break;
                    }
                }
                methodSb.append(parameterTypeName).append("\targ").append(i);
                if (i != length - 1) {
                    methodSb.append(",");
                }

            }
            methodSb.append(") throws Exception {\n");
            methodSb.append("\tClass<?>[] paramTypes = new Class<?>[").append(length).append("];\n");
            methodSb.append("\tObject[] args = new Object[").append(length).append("];\n");
            for (int i = 0; i < length; i++) {
                methodSb.append("\tparamTypes[").append(i).append("] = arg").append(i).append(".getClass()").append(";\n");
                methodSb.append("\targs[").append(i).append("] = arg").append(i).append(";\n");
            }
            methodSb.append("\tjava.lang.reflect.Method md = ")
                    .append(clazz.getName()).append(".class.getMethod(")
                    .append("\"").append(method.getName()).append("\", paramTypes").append(");\n");

            methodSb.append("\tinvokeHandler.invoke(md, args);\n");
            methodSb.append("}\n");
        }


        String proxyStr = String.format("package cn.maxlu.ijava.lang.reflect.proxy.my.v3;\n" +
                "\n" +
                "public class Proxy implements %s {\n" +
                "\tprivate cn.maxlu.ijava.lang.reflect.proxy.my.v3.InvokeHandler invokeHandler;\n" +
                "\tpublic Proxy(cn.maxlu.ijava.lang.reflect.proxy.my.v3.InvokeHandler invokeHandler) {\n" +
                "\t\tthis.invokeHandler = invokeHandler;\n" +
                "\t}\n" +
                "\n" +
                "%s" +
                "}", clazzName, methodSb.toString());

        System.out.println(proxyStr);

        String userDir = System.getProperty("user.dir");
        File root = new File(userDir + "\\target\\mytest\\");
        File javaFile = new File(root, "cn\\maxlu\\ijava\\lang\\reflect\\proxy\\my\\v3\\Proxy.java");
        javaFile.getParentFile().mkdirs();

        T proxy = null;
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
            Class<?> c = ul.loadClass("cn.maxlu.ijava.lang.reflect.proxy.my.v3.Proxy");

            //实例化
            Constructor<?> constructor = c.getConstructor(InvokeHandler.class);
            proxy = (T)constructor.newInstance(invokeHandler);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            File classFile = new File(root, "cn\\maxlu\\ijava\\lang\\reflect\\proxy\\my\\v3\\Proxy.class");
            javaFile.delete();
            classFile.delete();
        }

        return proxy;

    }
}
