package cn.maxlu;

import java.lang.reflect.Modifier;

/**
 * Created by luwei on 2017/5/25.
 */
public class Test {

    public static void main(String[] args) throws Exception {
        String s = Modifier.toString(Test.class.getModifiers());
        System.out.println(s);
    }

    protected void hello() {

    }


}
