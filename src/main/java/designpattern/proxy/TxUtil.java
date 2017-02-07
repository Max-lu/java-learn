package designpattern.proxy;

public class TxUtil {

    public void beginTx() {
        System.out.println("==begin tx==");
    }

    public void endTx() {
        System.out.println("==end tx==");
    }
}
