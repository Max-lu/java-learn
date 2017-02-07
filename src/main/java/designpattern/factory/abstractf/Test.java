package designpattern.factory.abstractf;

import designpattern.factory.Car;
import designpattern.factory.Color;

public class Test {
    public static void main(String[] args) {
        ColorFactory colorFactory = ColorFactoryFactory.getColorFactory("red");
        Color color = colorFactory.getColor();
        Car car = new Car();
        car.setColor(color);
        car.printInfo();
    }
}
