package cn.maxlu.java.learn.train.text;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by lw on 2016/11/19.
 */
public class PigGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();

        String newText = "";
        String[] list = {"a", "e", "i", "o", "u"};
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Arrays.binarySearch(list, ch + "") > 0) {
                continue;
            }
            newText = text.substring(0, i) + text.substring(i + 1) + "-" + ch + "ay";
            break;
        }
        System.out.println(newText);

        Pattern pattern = Pattern.compile("/[^(a & e & i & o & u)]/");
        String s = pattern.matcher(text).replaceFirst("8888");
        System.out.println(s);
    }
}
