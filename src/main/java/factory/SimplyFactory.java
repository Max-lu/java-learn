package factory;

/**
 * Created by max.lu on 2016/2/2.
 */
public class SimplyFactory {
    public static Color getColor(String type) {
        switch (type) {
            case "red":
                return new Red();
            case "blue":
                return new Blue();
            default:
                break;
        }
        return null;
    }
}
