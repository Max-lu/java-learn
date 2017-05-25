package cn.maxlu.designpattern.state;

/**
 * Created by luwei on 2017/5/8.
 * 电灯
 */
class Light {

    private LightState lightState;

    Light(LightState lightState) {
        this.lightState = lightState;
    }

    void pressSwitch() {
        lightState.switchState(this);
    }

    void setLightState(LightState lightState) {
        this.lightState = lightState;
    }
}
