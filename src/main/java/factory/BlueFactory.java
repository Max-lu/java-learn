package factory;

/**
 * Created by max.lu on 2016/2/2.
 */
public class BlueFactory implements ColorFactory {

    @Override
    public Color getColor() {
        return new Blue();
    }
}
