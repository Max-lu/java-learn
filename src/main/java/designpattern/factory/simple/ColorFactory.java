package designpattern.factory.simple;

import designpattern.factory.Color;
import designpattern.factory.Red;

public class ColorFactory {
    public static Color getColor() {
        return new Red();

        //when need to change the color implement, return different color implement
//        return new Blue();
    }
}
