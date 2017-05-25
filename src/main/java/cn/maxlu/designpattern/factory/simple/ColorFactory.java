package cn.maxlu.designpattern.factory.simple;

import cn.maxlu.designpattern.factory.Color;
import cn.maxlu.designpattern.factory.Red;

public class ColorFactory {
    public static Color getColor() {
        return new Red();

        //when need to change the color implement, return different color implement
//        return new Blue();
    }
}
