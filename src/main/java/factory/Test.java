package factory;

/**
 * Created by max.lu on 2016/2/2.
 */
public class Test {
    public static void main(String[] args) {
        simplyFactoryTest();
        factoryTest();
    }

    public static void simplyFactoryTest() {
        System.out.println("-------------");
        //实例化子类的时候会先调用父类的构造函数
        SimplyFactory.getColor("red");
        SimplyFactory.getColor("blue");
    }

    public static void factoryTest() {
        System.out.println("-------------");
        BlueFactory blueFactory = new BlueFactory();
        blueFactory.getColor();

        RedFactory redFactory = new RedFactory();
        redFactory.getColor();
    }
}
