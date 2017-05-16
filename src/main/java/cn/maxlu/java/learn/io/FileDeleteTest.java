package cn.maxlu.java.learn.io;

import org.junit.Assert;

import java.io.File;

/**
 * Created by max.lu on 2016/2/2.
 */
public class FileDeleteTest {

    public static void main(String[] args) {
        delete("E:\\test\\dir");
    }

    private static boolean delete(String name) {
        File file = new File(name);
        if (file.exists()) {
            if (file.isFile()) {
                return deleteFile(name);
            } else {
                return deleteDirectory(name);
            }
        } else {
            System.out.println("file doesn't exist...");
            return false;
        }
    }

    private static boolean deleteDirectory(String dir) {
        if (!dir.endsWith(File.separator)) {
            dir += File.separator;
        }
        File file = new File(dir);
        if (!file.exists() || !file.isDirectory()) {
            System.out.println("delete directory failed...");
            return false;
        }
        File[] files = file.listFiles();
        Assert.assertNotNull(files);
        boolean isSuccess;
        for (File file1 : files) {
            if (file1.isFile()) {
                isSuccess = deleteFile(file1.getAbsolutePath());
            } else {
                isSuccess = deleteDirectory(file1.getAbsolutePath());
            }
            if (!isSuccess) {
                System.out.println("delete directory failed...");
                return false;
            }
        }
        if (file.delete()) {
            System.out.println(String.format("delete directory [%s] successfully...", file.getAbsolutePath()));
            return true;
        } else {
            System.out.println("delete directory failed...");
            return false;
        }
    }

    private static boolean deleteFile(String name) {
        File file = new File(name);
        if (file.exists() && file.isFile()) {
            System.out.println(String.format("delete file [%s] successfully...", file.getAbsolutePath()));
            return file.delete();
        } else {
            System.out.println("delete file failed...");
            return false;
        }
    }
}
