package cn.maxlu.designpattern.factory.abstractf;

import cn.maxlu.designpattern.factory.Car;
import cn.maxlu.designpattern.factory.Color;

public class Test {
    public static void main(String[] args) {
        ColorFactory colorFactory = ColorFactoryFactory.getColorFactory("red");
        Color color = colorFactory.getColor();
        Car car = new Car();
        car.setColor(color);
        car.printInfo();
    }
}
