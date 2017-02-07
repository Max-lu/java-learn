package staticTest;

/**
 * Created by max.lu on 2016/1/27.
 */
public class Value {
    static int c = 0;

    Value() {
        c = 15;
    }

    Value(int i) {
        c = i;
    }

    static void inc() {
        c++;
    }
}
