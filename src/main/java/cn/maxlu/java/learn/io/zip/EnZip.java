package cn.maxlu.java.learn.io.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipOutputStream;

/**
 * Created by max.lu on 2016/3/24.
 */
public class EnZip {

    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) throws Exception {
        multiFiles();
    }

    private static void multiFiles() throws IOException {
        //压缩到一个目录下
        File file1 = new File("E:\\test");
        File zipFile = new File("E:\\test2\\test.zip");
        if (!zipFile.getParentFile().exists()) {
            zipFile.getParentFile().mkdirs();
        }
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFile));
        handlerFile(file1, out);
        out.close();
        System.out.println("success");
    }

    private static void handlerFile(File file1, ZipOutputStream out) throws IOException {
        if (file1.isDirectory()) {
            File[] files = file1.listFiles();
            if (files != null) {
                for (File file : files) {
                    handlerFile(file, out);
                }
            }
        } else {
            output(out, file1);
        }
    }

    private static void output(ZipOutputStream out, File file) throws IOException {
        InputStream in = new FileInputStream(file);
        try {
            out.putNextEntry(new ZipEntry(file.getName()));
        } catch (ZipException e) {
            out.putNextEntry(new ZipEntry(getName(file.getName())));
        }
        int temp;
        while ((temp = in.read()) != -1) {
            out.write(temp);
        }
        in.close();
    }

    private static String getName(String name) {
        int index = name.lastIndexOf(".");
        return name.substring(0, index) + atomicInteger.getAndIncrement() + name.substring(index);
    }

    private static void singleFile() throws IOException {
        File file1 = new File("E:\\test\\test1.txt");
        File zipFile = new File("E:\\test\\test.zip");
        InputStream in = new FileInputStream(file1);
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFile));
        out.putNextEntry(new ZipEntry(file1.getName()));
        out.setComment("comment");
        int temp;
        while ((temp = in.read()) != -1) {
            out.write(temp);
        }
        in.close();
        out.close();
    }
}
