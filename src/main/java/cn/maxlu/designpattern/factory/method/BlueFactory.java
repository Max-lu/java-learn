package cn.maxlu.designpattern.factory.method;

import cn.maxlu.designpattern.factory.Blue;
import cn.maxlu.designpattern.factory.Color;

public class BlueFactory {
    public static Color getColor() {
        return new Blue();
    }
}
