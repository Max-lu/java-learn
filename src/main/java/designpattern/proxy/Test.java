package designpattern.proxy;

public class Test {
    public static void main(String[] args) {
        GunDog gunDog = new GunDog();
        Dog dog = (Dog) MyProxyFactory.getProxy(gunDog);
        dog.info();
        dog.run();
    }
}
