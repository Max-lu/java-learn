package spring;

import java.util.concurrent.Callable;

public class HandlerUser implements Callable<User> {
    @Override
    public User call() throws Exception {
        User user = new User();
        user.setName("max");
        return user;
    }

}
