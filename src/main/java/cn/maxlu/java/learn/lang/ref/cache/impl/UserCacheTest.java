package cn.maxlu.java.learn.lang.ref.cache.impl;

/**
 * Created by luwei on 2017/5/23.
 */
public class UserCacheTest {
    public static void main(String[] args) {
        UserCache cache = UserCache.getInstance();
        System.out.println(cache.get("max"));
        System.out.println(cache.get("max2"));
        System.out.println(cache.get("max"));
        System.out.println(cache.get("max2"));

        cache.clearAll();

        System.out.println(cache.get("max"));
        System.out.println(cache.get("max2"));
    }
}
