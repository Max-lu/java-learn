package cn.maxlu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lw on 2016/7/18.
 */

public class Test {


    public static void main(String[] args) throws Exception {
        List<String> exts1 = new ArrayList<>();

    }

    public static <S> S get() {
        S s = (S)("123");
        return s;
    }

}
