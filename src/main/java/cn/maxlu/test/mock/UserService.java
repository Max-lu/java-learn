package cn.maxlu.test.mock;

class UserService {

    private UserDao userDao;

    User getUser(String name) {
        return userDao.getUser(name);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
