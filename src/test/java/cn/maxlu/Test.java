package cn.maxlu;

import java.io.File;

/**
 * Created by lw on 2016/7/18.
 */

public class Test {

    public static void main(String[] args) {
        new Test().test();

    }

    private void test() {
        File f = new File(this.getClass().getResource("/").getPath());
        System.out.println(f);
        System.out.println( System.getProperty("java.class.path"));
    }


}
