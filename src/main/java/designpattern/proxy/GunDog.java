package designpattern.proxy;

public class GunDog implements Dog {
    @Override
    public void info() {
        System.out.println("gun dog");
    }

    @Override
    public void run() {
        System.out.println("run faster");
    }
}
