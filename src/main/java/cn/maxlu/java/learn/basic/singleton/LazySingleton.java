package cn.maxlu.java.learn.basic.singleton;


class LazySingleton {

    private static LazySingleton lazySingleton = null;

    private LazySingleton() {

    }

    //not thread safe
    public static LazySingleton getInstance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
