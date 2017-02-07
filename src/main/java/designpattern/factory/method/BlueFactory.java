package designpattern.factory.method;

import designpattern.factory.Blue;
import designpattern.factory.Color;

public class BlueFactory {
    public static Color getColor() {
        return new Blue();
    }
}
