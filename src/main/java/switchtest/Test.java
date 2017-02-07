package switchtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by max.lu on 2016/2/19.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        while (true) {
            String name = new BufferedReader(new InputStreamReader(System.in)).readLine();
            switch (name.toUpperCase()) {
                case "SINGLE SIZE":
                case "SINGLESIZE":
                case "ONESIZE":
                case "ONE SIZE":
                    System.out.println("One size");
                    break;
                case "XL":
                    System.out.println("XL");
                    break;
                case "XS":
                    System.out.println("XS");
                    break;
                default:
                    System.out.println(name.substring(0, 1).toUpperCase() + name.substring(1));
                    break;
            }
        }

    }
}
