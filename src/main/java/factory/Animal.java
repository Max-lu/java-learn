package factory;

/**
 * Created by max.lu on 2016/2/2.
 */
public class Animal {

    private Animal() {

    }

    private static Animal animal;

    private String type = "color";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static Animal getInstance() {
        if (animal == null) {
            animal = new Animal();
        }
        return animal;
    }
}
