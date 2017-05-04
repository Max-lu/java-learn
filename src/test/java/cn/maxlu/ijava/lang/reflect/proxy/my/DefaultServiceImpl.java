package cn.maxlu.ijava.lang.reflect.proxy.my;

/**
 * Created by luwei on 2017/5/3.
 */
public class DefaultServiceImpl implements IService {
    @Override
    public void print() {
        System.out.println("default service");
    }
}
