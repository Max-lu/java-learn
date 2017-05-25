package cn.maxlu.java.learn.reflect.method;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by luwei on 2017/5/5.
 */
public class GetMethodTest {
    @Test
    public void test1() throws NoSuchMethodException {
        Method test1 = this.getClass().getDeclaredMethod("test", Map.class);
        Assert.assertNotNull(test1);
    }

    @Test(expected = NoSuchMethodException.class)
    public void test2() throws NoSuchMethodException {
        Method test2 = this.getClass().getDeclaredMethod("test", HashMap.class);
    }

    private void test(Map<String, Object> map) {

    }
}
