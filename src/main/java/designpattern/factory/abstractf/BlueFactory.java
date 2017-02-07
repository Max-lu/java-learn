package designpattern.factory.abstractf;

import designpattern.factory.Blue;
import designpattern.factory.Color;

public class BlueFactory implements ColorFactory {
    @Override
    public Color getColor() {
        return new Blue();
    }
}
