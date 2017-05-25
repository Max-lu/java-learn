package cn.maxlu.java.learn.spi;

/**
 * Created by luwei on 2017/4/21.
 */
public class Consumer {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("cn.maxlu.spi.basic.ProviderOne");
        Class.forName("cn.maxlu.spi.basic.ProviderTwo");

        IService service1 = ServiceUtil.getService("one");
        IService service2 = ServiceUtil.getService("two");
        service1.service();
        service2.service();
    }
}
