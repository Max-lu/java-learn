package singleton;

public class Test {
    public static void main(String[] args) {
        LazySingleton5 instance1 = LazySingleton5.INSTANCE;
        instance1.setName("max1111");
        System.out.println(instance1.getName());

        LazySingleton5 instance2 = LazySingleton5.INSTANCE;
        instance2.setName("max2222");
        System.out.println(instance1.getName());
        System.out.println(instance2.getName());

        System.out.println(instance1 == instance2);
    }
}
