package designpattern.state;

/**
 * Created by luwei on 2017/5/8.
 */
class Test {
    public static void main(String[] args) {
        Light light = new Light(new Off());
        for (int i = 0; i < 10; i++) {
            light.pressSwitch();
        }
    }
}
