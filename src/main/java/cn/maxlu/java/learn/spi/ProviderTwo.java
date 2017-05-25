package cn.maxlu.java.learn.spi;

/**
 * Created by luwei on 2017/4/21.
 */
public class ProviderTwo implements IService {

    static {
        System.out.println("providerTwo loaded");
        ServiceUtil.register("two", ProviderTwo.class);
    }

    @Override
    public void service() {
        System.out.println("provider two service");
    }
}
