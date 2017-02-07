package io.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by max.lu on 2016/3/24.
 */
public class EnZip2 {
    private static final String PATH = "E:\\test\\";

    public static void main(String[] args) throws Exception {
        //保持目录
        File file1 = new File("E:\\test");
        File zipFile = new File("E:\\test2\\test3.zip");
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
        out.putNextEntry(new ZipEntry(file.getPath().replace(PATH, "")));
        int temp;
        while ((temp = in.read()) != -1) {
            out.write(temp);
        }
        in.close();
    }

}
