package cn.maxlu.ijava.lang.reflect.modifier;

import org.junit.Test;

import java.lang.reflect.Modifier;

/**
 * Created by luwei on 2017/5/5.
 */
public final class GetModifierTest {
    @Test
    public void test() {
        String s1 = Modifier.toString(this.getClass().getModifiers());
        String s2 = Modifier.toString(this.getClass().getModifiers() & Modifier.FINAL);
        String s3 = Modifier.toString(this.getClass().getModifiers() | Modifier.FINAL);
        String s4 = Modifier.toString(this.getClass().getModifiers() ^ Modifier.FINAL);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
    }
}
