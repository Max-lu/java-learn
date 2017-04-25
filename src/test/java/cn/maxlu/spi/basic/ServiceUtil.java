package cn.maxlu.spi.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Created by luwei on 2017/4/21.
 */
public class ServiceUtil {

    private ServiceUtil(){

    }

    private static Map<String, Class<? extends IService>> services = new HashMap<>();

    public static void register(String name, Class<? extends IService> service) {
        services.putIfAbsent(name, service);
    }

    public static IService getService(String name) {
        try {
            return services.get(name).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new NoSuchElementException("can't find corresponding service");
        }
    }

}
