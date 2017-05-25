package cn.maxlu.spring;

import java.util.concurrent.Callable;

class HandlerUser implements Callable<User> {
    @Override
    public User call() throws Exception {
        User user = new User();
        user.setName("max");
        return user;
    }

}
