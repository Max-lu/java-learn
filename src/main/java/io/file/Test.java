package io.file;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.Writer;

/**
 * Created by max.lu on 2016/3/24.
 */
public class Test {

    private static final String PATH1 = "E:" + File.separator + "test" + File.separator + "test.txt";
    private static final String PATH2 = "E:" + File.separator + "test" + File.separator + "test2.txt";

    private static final String PATH = "E:" + File.separator + "test" + File.separator + "test2";

    public static void main(String[] args) throws IOException {
        newFile();
    }

    private static void newFile() throws IOException {
        File file = new File("E:\\test3\\test3\\test3\\test3.txt");
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
        }
    }

    private static void byteArray() throws IOException {
    /*
    ByteArrayInputStream 主要将内容写入内存
    ByteArrayOutputStream 主要将内容从内存输出
     */
        String source = "HELLO WORLD";
        ByteArrayInputStream in = new ByteArrayInputStream(source.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int temp;
        char ch;
        while ((temp = in.read()) != -1) {
            ch = (char) temp;
            out.write(Character.toLowerCase(ch));
        }
        in.close();
        out.close();
        System.out.println(out.toString());
    }

    private static void exchange() throws IOException {
        //字节流转换成字符流
        File file1 = new File(PATH1);
        Writer writer = new OutputStreamWriter(new FileOutputStream(file1));
        String s = "hello world";
        writer.write(s);
        writer.close();

        File file2 = new File(PATH1);
        Reader reader = new InputStreamReader(new FileInputStream(file2));
        char[] chars = new char[1024];
        int count = 0;
        int temp;
        while ((temp = reader.read()) != -1) {
            chars[count++] = (char) temp;
        }
        reader.close();
        System.out.println(new String(chars, 0, count));
    }

    private static void copyFile(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("args error");
            System.exit(1);
        }
        File file1 = new File(PATH1);
        File file2 = new File(PATH2);
        if (!file1.exists()) {
            System.out.println("source does not exist");
            System.exit(1);
        }
        InputStream in = new FileInputStream(file1);
        OutputStream out = new FileOutputStream(file2);
        int temp;
        while ((temp = in.read()) != -1) {
            out.write(temp);
        }
        in.close();
        out.close();
    }

    private static void reader() throws IOException {
        File file = new File(PATH1);
        Reader reader = new FileReader(file);
        char[] result = new char[1024];
        int len = reader.read(result);
        System.out.println("len=" + len);
        System.out.println(new String(result));
    }

    private static void writer() throws IOException {
        //字符流
        File file = new File(PATH1);
        Writer writer = new FileWriter(file, true);
        String s = "\r\nhello";
        writer.write(s);
        writer.close();
    }

    private static void eof() throws IOException {
        File file = new File(PATH1);
        InputStream in = new FileInputStream(file);
        byte[] bytes = new byte[1024];
        int count = 0;
        int temp;
        while ((temp = in.read()) != -1) {
            bytes[count++] = (byte) temp;
        }
        in.close();
        System.out.println(new String(bytes));
    }

    private static void readFile() throws IOException {
        File file = new File(PATH1);
        InputStream in = new FileInputStream(file);
        byte[] bytes = new byte[(int) file.length()];
        int len = in.read(bytes);
        in.close();
        System.out.println(new String(bytes, 0, len));

    }

    private static void appendWrite() throws IOException {
        File file = new File(PATH1);
        OutputStream out = new FileOutputStream(file, true);
        byte[] bytes = "max".getBytes();
        out.write(bytes);
        out.close();
    }

    private static void overwrite() throws IOException {
        //字节流
        File file = new File(PATH1);
        OutputStream out = new FileOutputStream(file);
        byte[] bytes = "max".getBytes();
        out.write(bytes);
        out.close();
    }

    private static void randomRW() throws IOException {
        File file = new File(PATH1);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        randomAccessFile.writeBoolean(true);
        randomAccessFile.writeDouble(1.22);
        randomAccessFile.close();
    }

    private static void searchAllFile() {
        File file = new File(PATH);
        print(file);
    }

    private static void print(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File file1 : files) {
                    print(file1);
                }
            }
        } else {
            System.out.println(file);
        }
    }

    private static void isDirectory() {
        File file1 = new File(PATH1);
        System.out.println(file1.isDirectory());
        File file2 = new File(PATH);
        System.out.println(file2.isDirectory());
    }

    private static void listFiles() {
        File file = new File(PATH);
        //names
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }

        //files
        File[] files = file.listFiles();
        assert files != null;
        for (File file1 : files) {
            System.out.println(file1);
        }
    }

    private static void createDir() {
        File file = new File(PATH);
        boolean mkdir = file.mkdir();
        System.out.println("create dir " + (mkdir ? "success" : "fail"));
    }

    private static void createAndDeleteFile() throws IOException {
        File file = new File(PATH1);
        boolean createSuccess = file.createNewFile();
        System.out.println(createSuccess ? "create success" : "create fail");

        if (file.exists()) {
            boolean deleteSuccess = file.delete();
            System.out.println(deleteSuccess ? "delete success" : "delete fail");
        }
    }

    private static void ifFileExist() {
        File file = new File(PATH1);
        if (file.exists()) {
            System.out.println("exist");
        } else {
            System.out.println("not exist");
        }
    }

    private static void getConstants() {
        System.out.println(File.separator);
        System.out.println(File.pathSeparator);
    }
}
