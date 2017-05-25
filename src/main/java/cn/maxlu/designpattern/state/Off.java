package cn.maxlu.designpattern.state;

/**
 * Created by luwei on 2017/5/8.
 */
class Off implements LightState {
    @Override
    public void switchState(Light light) {
        System.out.println("turn on the light");
        light.setLightState(new On());
    }
}
