package cn.maxlu.designpattern.factory.simple;

import cn.maxlu.designpattern.factory.Car;
import cn.maxlu.designpattern.factory.Color;

public class Test {
    public static void main(String[] args) {
        Color color = ColorFactory.getColor();
        Car car = new Car();
        car.setColor(color);
        car.printInfo();
    }
}
