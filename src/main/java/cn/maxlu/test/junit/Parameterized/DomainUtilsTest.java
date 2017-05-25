package cn.maxlu.test.junit.Parameterized;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class DomainUtilsTest {
    private String domain;
    private boolean expected;

    public DomainUtilsTest(String domain, boolean expected) {
        this.domain = domain;
        this.expected = expected;
    }

    @Parameters(name = "{index}: isValid({0})={1}")
    public static Collection data() {
        return Arrays.asList(new Object[][]{{"google.com", true}, {"yiibai.com", true}, {"-yiibai.com", false}, {"yiibai-.com", false}, {"3423kjk", false}, {"mk#$kdo.com", false}});
    }

    @Test
    public void test_validDomains() {
        Assert.assertEquals(expected, DomainUtils.isValidDomainName(domain));
    }
}
