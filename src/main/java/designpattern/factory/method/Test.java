package designpattern.factory.method;

import designpattern.factory.Car;
import designpattern.factory.Color;

public class Test {
    public static void main(String[] args) {
        //when need change color implement, use different factory
        Color color = BlueFactory.getColor();
        Car car = new Car();
        car.setColor(color);
        car.printInfo();
    }
}
