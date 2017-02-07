package designpattern.factory.simple;

import designpattern.factory.Car;
import designpattern.factory.Color;

public class Test {
    public static void main(String[] args) {
        Color color = ColorFactory.getColor();
        Car car = new Car();
        car.setColor(color);
        car.printInfo();
    }
}
