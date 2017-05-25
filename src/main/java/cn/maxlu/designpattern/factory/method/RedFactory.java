package cn.maxlu.designpattern.factory.method;

import cn.maxlu.designpattern.factory.Color;
import cn.maxlu.designpattern.factory.Red;

public class RedFactory {
    public static Color getColor() {
        return new Red();
    }
}
