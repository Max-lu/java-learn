package cn.maxlu.ijava.lang.reflect.proxy.my;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by luwei on 2017/5/3.
 */
public class DefaultService2Impl implements IService2 {

    @Override
    public void print(String arg1, HashMap<String, Object> arg2, int[] arg3, String... arg4) {
        System.out.println("service 2");
        System.out.println("arg1=" + arg1);
        System.out.println("arg2=" + arg2);
        System.out.println("arg3=" + Arrays.toString(arg3));
        System.out.println("arg4=" + Arrays.toString(arg4));
    }
}
