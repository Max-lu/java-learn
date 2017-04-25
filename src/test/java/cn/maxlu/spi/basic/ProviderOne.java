package cn.maxlu.spi.basic;

/**
 * Created by luwei on 2017/4/21.
 */
public class ProviderOne implements IService {

    static {
        System.out.println("providerOne loaded");
        ServiceUtil.register("one", ProviderOne.class);
    }

    @Override
    public void service() {
        System.out.println("provider one service");
    }
}
