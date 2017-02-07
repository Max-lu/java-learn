package io.print;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by max.lu on 2016/3/24.
 */
public class Test {
    private static final String PATH1 = "E:" + File.separator + "test" + File.separator + "test.txt";

    public static void main(String[] args) throws Exception {
        scannerFile();
    }

    private static void scannerFile() throws FileNotFoundException {
        File file = new File(PATH1);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String next = scanner.next();
            System.out.println(next);
        }
    }

    private static void consoleInput() throws IOException {
        //method 1
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String in = buff.readLine();
        System.out.println(in);

        //method 2
        Scanner scanner = new Scanner(System.in);
        int in2 = scanner.nextInt();
        System.out.println(in2);
    }

    private static void redirectIn() throws IOException {
        File file = new File(PATH1);
        System.setIn(new FileInputStream(file));
        byte[] bytes = new byte[1024];
        int len = System.in.read(bytes);
        System.out.println(new String(bytes, 0, len));
    }

    private static void redirectErr() {
        System.err.println("hello world");
        File file = new File(PATH1);
        try {
            System.setErr(new PrintStream(new FileOutputStream(file)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.err.println("hello world 22");
    }

    private static void redirectOut() {
        System.out.println("hello world");
        File file = new File(PATH1);
        try {
            System.setOut(new PrintStream(new FileOutputStream(file)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("hello world 2");
    }

    private static void systemOut() {
        PrintStream out = System.out;
        try {
            out.write("hello world".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.close();
    }

    private static void method1() throws FileNotFoundException {
        File file = new File(PATH1);
        PrintStream printStream = new PrintStream(new FileOutputStream(file));
        //控制台标准输出
//        PrintStream printStream = new PrintStream(new FileOutputStream(FileDescriptor.out));
        printStream.println("hello");
        printStream.println(true);
        printStream.printf("hello %s %d", "max", 1);
        printStream.close();
    }
}
