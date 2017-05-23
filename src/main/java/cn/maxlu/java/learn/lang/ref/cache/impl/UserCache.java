package cn.maxlu.java.learn.lang.ref.cache.impl;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by luwei on 2017/5/23.
 */
class UserCache {

    private Map<String, UserReference> caches;

    private ReferenceQueue<User> referenceQueue;

    private static UserCache instance;

    private static class UserReference extends SoftReference<User> {

        private String key;

        UserReference(User referent, ReferenceQueue<? super User> q) {
            super(referent, q);
            key = referent.getName();
        }

        String getKey() {
            return key;
        }
    }

    private UserCache() {
        if (instance != null) {
            throw new IllegalAccessError("has initialized");
        }
        this.caches = new HashMap<>();
        this.referenceQueue = new ReferenceQueue<>();
    }

    public static UserCache getInstance() {
        if (instance == null) {
            synchronized (User.class) {
                if (instance == null) {
                    instance = new UserCache();
                }
            }
        }
        return instance;
    }

    public User get(String name) {
        Reference<User> userReference = caches.get(name);
        if (userReference == null) {
            System.out.println("get from db...");
            clearCache();
            User user = new User(name);
            caches.put(name, new UserReference(user, referenceQueue));
        } else {
            System.out.println("get from cache...");
        }
        return caches.get(name).get();
    }

    /**
     * 清除已被gc回收的对象
     */
    private void clearCache() {
        UserReference user;
        while ((user = (UserReference) referenceQueue.poll()) != null) {
            caches.remove(user.getKey());
        }
    }

    void clearAll() {
        caches.clear();
        System.gc();
        System.runFinalization();
    }
}
