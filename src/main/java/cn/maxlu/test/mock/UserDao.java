package cn.maxlu.test.mock;

class UserDao {
    User getUser(String name) {
        return new User();
    }
}
