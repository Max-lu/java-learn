package cn.maxlu.java.learn.basic.singleton;

class EagerSingleton {
    private static EagerSingleton eagerSingleton = new EagerSingleton();

    private EagerSingleton() {

    }

    public static EagerSingleton getInstance() {
        return eagerSingleton;
    }
}
