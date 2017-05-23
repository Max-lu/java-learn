package cn.maxlu;

import sun.misc.Unsafe;

/**
 * Created by lw on 2016/7/18.
 */

public class Test {

    public static void main(String[] args) throws Exception {
        Unsafe unsafe = Unsafe.getUnsafe();
        long l = unsafe.allocateMemory(1024);
    }


}
