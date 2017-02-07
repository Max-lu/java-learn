package mock;

import org.easymock.EasyMock;
import org.junit.Assert;

public class Test {

    /*
    注意：
在EasyMock3.0之前，org.easymock.EasyMock使用JDK的动态代理实现Mock对象创建，因此只能针对接口进行Mock，org.easymock.classextension.EasyMock使用CGLIB动态代理创建Mock对象，可以针对普通类进行Mock。
在EasyMock3.0之后，org.easymock.classextension.EasyMock被废弃，使用org.easymock.EasyMock可以针对接口和普通类进行Mock对象创建
    * */
    @org.junit.Test
    public void testGetUser() {
        User exceptedUser = new User();
        exceptedUser.setName("max");
        UserDao mock = EasyMock.createMock(UserDao.class);
        EasyMock.expect(mock.getUser("max")).andReturn(exceptedUser).times(3);
        EasyMock.replay(mock);

        UserService userService = new UserService();
        userService.setUserDao(mock);
        User user = userService.getUser("max");
        Assert.assertEquals(exceptedUser, user);
        EasyMock.verify(mock);
    }
}
