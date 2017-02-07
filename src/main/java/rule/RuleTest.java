package rule;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by max.lu on 2016/3/23.
 */
public class RuleTest {

    @Before
    public void before() {
        System.out.println("before");
    }

    @After
    public void after() {
        System.out.println("after");
    }

    //must be static
    @BeforeClass
    public static void beforeClass() {
        System.out.println("before class");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("before class");
    }

    //Rule是一个用于测试单元类如MyTest中定义一个域的标注，该域must be public, not static, and a subtype of  org.junit.rules.MethodRule。
    @Rule
    public MyRule myRule = new MyRule();

//    @Rule
//    public MyRule myRule2(){
//        return new MyRule();
//    }

    @Test
    public void testRule1(){
        System.out.println("test1");
    }

    @Test
    public void testRule2(){
        System.out.println("test2");
    }
}
