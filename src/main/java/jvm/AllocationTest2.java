package jvm;

/**
 * Created by lw on 2017/3/28.
 */
public class AllocationTest2 {
    public static void main(String[] args) {
        byte[] allocation1;
        allocation1 = new byte[4194304];
        allocation1 = null;

        System.gc();
        //allocation2 = new byte[262144];
        //System.gc();
//        allocation3 = new byte[4194304];
//        allocation3 = null;
//        allocation3 = new byte[4194304];
    }

    public void hello() {
        System.out.println("hello");
    }
}
