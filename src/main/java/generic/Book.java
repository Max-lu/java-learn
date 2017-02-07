package generic;

/**
 * Created by max.lu on 2016/2/2.
 */
public class Book<T> {
    private T attr;

    public T getAttr() {
        return attr;
    }

    public void setAttr(T attr) {
        this.attr = attr;
    }
}
