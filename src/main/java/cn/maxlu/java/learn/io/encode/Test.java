package cn.maxlu.java.learn.io.encode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Test {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\test\\test.txt");
        byte[] bytes = "你好".getBytes("ISO8859-1");
        OutputStream out = new FileOutputStream(file);
        out.write(bytes);
    }

    private static void getDefaultEncoding() {
        System.out.println(System.getProperty("file.encoding"));
    }
}
