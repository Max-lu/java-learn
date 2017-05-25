package cn.maxlu.java.learn.basic.singleton;

class LazySingleton3 {

    private volatile static LazySingleton3 lazySingleton = null;

    private LazySingleton3() {

    }

    //double-check-lock, effective
    public static LazySingleton3 getInstance() {
        if (lazySingleton == null) {
            synchronized (LazySingleton3.class) {
                if (lazySingleton == null) {
                    lazySingleton = new LazySingleton3();
                }
            }
        }
        return lazySingleton;
    }
}
