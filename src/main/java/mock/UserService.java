package mock;

public class UserService {

    private UserDao userDao;

    public User getUser(String name) {
        return userDao.getUser(name);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
