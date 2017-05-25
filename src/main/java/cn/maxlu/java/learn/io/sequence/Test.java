package cn.maxlu.java.learn.io.sequence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;

/**
 * Created by max.lu on 2016/3/24.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        File file1 = new File("E:\\test\\test1.txt");
        File file2 = new File("E:\\test\\test2.txt");
        File file3 = new File("E:\\test\\test3.txt");
        InputStream in1 = new FileInputStream(file1);
        InputStream in2 = new FileInputStream(file2);
        OutputStream out = new FileOutputStream(file3);
        SequenceInputStream sin = new SequenceInputStream(in1, in2);
        int temp;
        while ((temp = sin.read()) != -1) {
            out.write(temp);
        }
        in1.close();
        in2.close();
        out.close();
        sin.close();
    }
}
