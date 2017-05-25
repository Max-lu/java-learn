package cn.maxlu.designpattern.factory.abstractf;

import java.util.Objects;

public class ColorFactoryFactory {
    public static ColorFactory getColorFactory(String type) {
        Objects.requireNonNull(type, "type should not be null...");
        //when need change color implement, add new branch here
        if (Objects.equals("red", type)) {
            return new RedFactory();
        } else if (Objects.equals("blue", type)) {
            return new BlueFactory();
        }

        return new RedFactory();//default
    }
}
