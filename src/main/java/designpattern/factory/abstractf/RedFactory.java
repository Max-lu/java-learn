package designpattern.factory.abstractf;

import designpattern.factory.Color;
import designpattern.factory.Red;

public class RedFactory implements ColorFactory {
    @Override
    public Color getColor() {
        return new Red();
    }
}
