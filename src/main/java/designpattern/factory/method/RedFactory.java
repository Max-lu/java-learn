package designpattern.factory.method;

import designpattern.factory.Color;
import designpattern.factory.Red;

public class RedFactory {
    public static Color getColor() {
        return new Red();
    }
}
