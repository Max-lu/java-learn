package cn.maxlu.java.learn.bean;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by luwei on 2017/6/9.
 */
public class PropertyDescriptorTest {

    private static void setProperty(Boy bean, String propertyName, Object value) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        PropertyDescriptor descriptor = new PropertyDescriptor(propertyName, bean.getClass());
        Method writeMethod = descriptor.getWriteMethod();
        writeMethod.invoke(bean, value);
    }

    @SuppressWarnings("unchecked")
    private static <T> T getProperty(Boy bean, String propertyName) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        PropertyDescriptor descriptor = new PropertyDescriptor(propertyName, bean.getClass());
        Method readMethod = descriptor.getReadMethod();
        return (T) readMethod.invoke(bean);
    }

    public static void main(String[] args) throws Exception {
        Boy boy = new Boy("max", 18, true);

        String name1 = getProperty(boy, "name");
        boolean girl1 = getProperty(boy, "hasGirl");
        System.out.println("name=" + name1 + ", hasGirl=" + girl1);

        setProperty(boy, "name", "max2");
        setProperty(boy, "hasGirl", false);

        String name2 = getProperty(boy, "name");
        boolean girl2 = getProperty(boy, "hasGirl");
        System.out.println("name=" + name2 + ", hasGirl=" + girl2);
    }
}
