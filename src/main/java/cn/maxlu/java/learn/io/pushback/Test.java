package cn.maxlu.java.learn.io.pushback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

public class Test {
    public static void main(String[] args) throws IOException {
        String source = "1hello china 2hello world";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(source.getBytes());
        PushbackInputStream pushbackInputStream = new PushbackInputStream(byteArrayInputStream);
        int temp;
        while ((temp = pushbackInputStream.read()) != -1) {
            if (temp == '2') {
                pushbackInputStream.unread(temp);
                System.out.print("(push back char " + (char) temp + ")");
                break;
            } else {
                System.out.print((char)temp);
            }
        }

        System.out.println("\nremain char in stream:");
        while ((temp = pushbackInputStream.read()) != -1) {
            System.out.print((char) temp);
        }
        System.out.println();
        byteArrayInputStream.close();
        pushbackInputStream.close();
    }
}
