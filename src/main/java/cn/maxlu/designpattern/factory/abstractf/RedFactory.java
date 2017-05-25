package cn.maxlu.designpattern.factory.abstractf;

import cn.maxlu.designpattern.factory.Color;
import cn.maxlu.designpattern.factory.Red;

public class RedFactory implements ColorFactory {
    @Override
    public Color getColor() {
        return new Red();
    }
}
