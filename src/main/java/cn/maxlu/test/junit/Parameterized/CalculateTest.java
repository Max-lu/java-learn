package cn.maxlu.test.junit.Parameterized;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CalculateTest {

    private int expected;

    private int first;

    private int second;

    public CalculateTest(int expected, int first, int second) {
        this.expected = expected;
        this.first = first;
        this.second = second;
    }

    @Parameterized.Parameters
    public static Collection getData() {
        return Arrays.asList(new Integer[][]{{3, 1, 2}, {5, 2, 3}});
    }

    @Test
    public void testAdd() {
        Calculate calculate = new Calculate();
        System.out.println("Addition with parameters : " + first + " and " + second);
        Assert.assertEquals(expected, calculate.add(first, second));
    }
}
