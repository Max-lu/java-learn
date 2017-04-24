package jvm;

/**
 * Created by lw on 2017/3/28.
 */
public class AllocationTest {

    private String a = "2";
    private String a1 = "2";
    private String a2 = "2";
    private String a3 = "2";
    private String a4 = "2";
    private String a5 = "2";
    private String a67 = "2";
    private String a7 = "2";
    private String a11 = "2";
    private String a12 = "2";
    private String a13 = "2";
    private String a15 = "2";
    private String a14 = "2";
    private String a16 = "2";
    private String a17 = "2";
    public static void main(String[] args) throws InterruptedException {
        byte[] allocation1;
        allocation1 = new byte[4194304];
        allocation1 = null;

        AllocationTest2 allocationTest2 = new AllocationTest2();
        allocationTest2.hello();
        System.gc();

        //6%是什么

//        Thread.sleep(1000000000);
        //allocation2 = new byte[262144];
        //System.gc();
//        allocation3 = new byte[4194304];
//        allocation3 = null;
//        allocation3 = new byte[4194304];
    }

    private void hello() {
        System.out.println("hello");
    }
}
