package cn.maxlu.java.learn.bean.apache;

import cn.maxlu.java.learn.bean.Boy;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by luwei on 2017/6/9.
 */
public class BeanUtilTest {
    public static void main(String[] args) throws Exception{
        propertyUtils();
    }

    private static void propertyUtils() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Boy boy = new Boy("max", 18, true);

        String name1 = (String) PropertyUtils.getProperty(boy, "name");
        boolean girl1 = (boolean) PropertyUtils.getProperty(boy, "hasGirl");
        System.out.println("name=" + name1 + ", hasGirl=" + girl1);

        PropertyUtils.setProperty(boy, "name", "max2");
        PropertyUtils.setProperty(boy, "hasGirl", false);

        String name2 = (String) PropertyUtils.getProperty(boy, "name");
        boolean girl2 = (boolean) PropertyUtils.getProperty(boy, "hasGirl");
        System.out.println("name=" + name2 + ", hasGirl=" + girl2);
    }

    private static void beanUtils() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Boy boy = new Boy("max", 18, true);

        String name1 = BeanUtils.getProperty(boy, "name");
        String girl1 = BeanUtils.getProperty(boy, "hasGirl");
        System.out.println("name=" + name1 + ", hasGirl=" + girl1);

        BeanUtils.setProperty(boy, "name", "max2");
        BeanUtils.setProperty(boy, "hasGirl", false);

        String name2 = BeanUtils.getProperty(boy, "name");
        String girl2 = BeanUtils.getProperty(boy, "hasGirl");
        System.out.println("name=" + name2 + ", hasGirl=" + girl2);
    }
}
