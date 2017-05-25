package cn.maxlu.designpattern.factory.abstractf;

import cn.maxlu.designpattern.factory.Blue;
import cn.maxlu.designpattern.factory.Color;

public class BlueFactory implements ColorFactory {
    @Override
    public Color getColor() {
        return new Blue();
    }
}
