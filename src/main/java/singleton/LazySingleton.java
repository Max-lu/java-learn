package singleton;


public class LazySingleton {

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
