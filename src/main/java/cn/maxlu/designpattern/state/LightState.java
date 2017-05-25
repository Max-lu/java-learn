package cn.maxlu.designpattern.state;

/**
 * Created by luwei on 2017/5/8.
 * 电灯的状态
 */
interface LightState {
    void switchState(Light light);
}
