package designpattern.factory;

public class Car {
    private Color color;

    public void printInfo() {
        color.info();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
