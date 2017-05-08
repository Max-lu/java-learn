package designpattern.state;

/**
 * Created by luwei on 2017/5/8.
 */
class On implements LightState {
    @Override
    public void switchState(Light light) {
        System.out.println("turn off the light");
        light.setLightState(new Off());
    }
}
