package mock;

public class UserDao {
    public User getUser(String name) {
        return new User();
    }
}
