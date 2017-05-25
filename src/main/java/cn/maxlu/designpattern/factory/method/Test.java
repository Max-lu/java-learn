package cn.maxlu.designpattern.factory.method;

import cn.maxlu.designpattern.factory.Car;
import cn.maxlu.designpattern.factory.Color;

public class Test {
    public static void main(String[] args) {
        //when need change color implement, use different factory
        Color color = BlueFactory.getColor();
        Car car = new Car();
        car.setColor(color);
        car.printInfo();
    }
}
