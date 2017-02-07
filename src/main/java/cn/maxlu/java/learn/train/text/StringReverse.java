package cn.maxlu.java.learn.train.text;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by lw on 2016/11/17.
 */
public class StringReverse {
    public static void main(String[] args) throws Exception {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\ninput text:\n");
        String text = reader.readLine();

        String reversedText = reverse7(text);

        System.out.println(reversedText);

        //耗时测试
        timeUsed(text);

    }

    private static void timeUsed(String text) {
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            reverse1(text);
        }
        long end1 = System.currentTimeMillis();
        System.out.println("cost1:" + (end1 - start1));

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            reverse2(text);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("cost2:" + (end2 - start2));

        long start3 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            reverse3(text);
        }
        long end3 = System.currentTimeMillis();
        System.out.println("cost3:" + (end3 - start3));

        long start4 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            reverse4(text);
        }
        long end4 = System.currentTimeMillis();
        System.out.println("cost4:" + (end4 - start4));


        long start5 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            reverse5(text);
        }
        long end5 = System.currentTimeMillis();
        System.out.println("cost5:" + (end5 - start5));

        long start6 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            reverse6(text);
        }
        long end6 = System.currentTimeMillis();
        System.out.println("cost6:" + (end6 - start6));

        long start7 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            reverse7(text);
        }
        long end7 = System.currentTimeMillis();
        System.out.println("cost7:" + (end7 - start7));
    }

    private static String reverse1(String text) {
        int length = text.length();
        String[] charArray = new String[length];
        for (int i = 0; i < length; ) {
            charArray[i] = text.substring(i, ++i);
        }
        StringBuilder sb = new StringBuilder(length);
        for (int i = length - 1; i > -1; i--) {
            sb.append(charArray[i]);
        }
        return sb.toString();
    }

    private static String reverse2(String text) {
        int len = text.length();
        int mid = len / 2;
        if (mid == 0) {
            return text;
        }
        return reverse2(text.substring(mid, len)) + reverse2(text.substring(0, mid));
    }

    private static String reverse3(String text) {
        int len = text.length();
        String result = "";
        for (int i = 0; i < len; i++) {
            result = text.charAt(i) + result;
        }
        return result;
    }

    private static String reverse4(String text) {
        return new StringBuilder(text).reverse().toString();
    }

    /*
    效果拔群
     */
    private static String reverse5(String text) {
        char[] chars = text.toCharArray();
        int len = text.length();
        int mid = len / 2;
        for (int i = 0; i <= mid; i++) {
            char tmp = chars[len - 1 - i];
            chars[len - 1 - i] = chars[i];
            chars[i] = tmp;
        }
        return new String(chars);
    }

    //not understand
    private static String reverse6(String s) {
        char[] str = s.toCharArray();
        int begin = 0;
        int end = s.length() - 1;
        while (begin < end) {
            str[begin] = (char) (str[begin] ^ str[end]);
            str[end] = (char) (str[begin] ^ str[end]);
            str[begin] = (char) (str[end] ^ str[begin]);
            begin++;
            end--;
        }
        return new String(str);
    }

    private static String reverse7(String s) {
        char[] str = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aStr : str) stack.push(aStr);
        String reversed = "";
        while (!stack.empty()) {
            reversed += stack.pop();
        }
        return reversed;
    }

}
