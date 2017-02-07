package io.data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by max.lu on 2016/3/24.
 */
public class Test {
    private static final String PATH1 = "E:" + File.separator + "test" + File.separator + "test.txt";

    public static void main(String[] args) throws Exception {
        dataRead();
    }

    private static void dataRead() throws IOException {
        File file = new File(PATH1);
        DataInputStream in = new DataInputStream(new FileInputStream(file));
        char[] result = new char[1024];
        int count = 0;
        int temp;
        while ((temp = in.readChar()) != 'c') {
            result[count++] = (char) temp;
        }
        System.out.println(new String(result));
    }

    private static void dataWrite() throws IOException {
        File file = new File(PATH1);
        DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
        char[] data = {'a', 'b', 'c'};
        for (char ch : data) {
            out.writeChar(ch);
        }
        out.close();
    }
}
