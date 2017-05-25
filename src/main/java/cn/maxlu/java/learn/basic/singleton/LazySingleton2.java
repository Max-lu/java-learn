package cn.maxlu.java.learn.basic.singleton;

class LazySingleton2 {

    //volatile
    //1.可见性，当前线程修改会立即写回主存
    //2.禁止指令重排序优化（work since jdk1.5）
    private volatile static LazySingleton2 lazySingleton = null;

    private LazySingleton2() {

    }

    //relatively thread safe, but not effective because it's almost not null
    public static LazySingleton2 getInstance() {
        synchronized (LazySingleton2.class) {
            if (lazySingleton == null) {
                lazySingleton = new LazySingleton2();
            }
        }
        return lazySingleton;
    }
}
