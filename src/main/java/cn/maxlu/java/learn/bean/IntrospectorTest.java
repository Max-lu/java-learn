package cn.maxlu.java.learn.bean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * Created by luwei on 2017/6/9.
 */
public class IntrospectorTest {

    private static void setProperty(Boy bean, String propertyName, Object value) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor descriptor : propertyDescriptors) {
            if (Objects.equals(descriptor.getName(), propertyName)) {
                Method writeMethod = descriptor.getWriteMethod();
                writeMethod.invoke(bean, value);
            }
        }
    }

    private static Object getProperty(Boy bean, String propertyName) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor descriptor : propertyDescriptors) {
            if (Objects.equals(descriptor.getName(), propertyName)) {
                Method readMethod = descriptor.getReadMethod();
                return readMethod.invoke(bean);
            }
        }
        throw new RuntimeException("fail");
    }

    public static void main(String[] args) throws Exception {
        Boy boy = new Boy("max", 18, true);

        Object name1 = getProperty(boy, "name");
        Object hasGirl1 = getProperty(boy, "hasGirl");
        System.out.println("name=" + name1 + ", hasGirl=" + hasGirl1);

        setProperty(boy, "name", "max2");
        setProperty(boy, "hasGirl", false);

        Object name2 = getProperty(boy, "name");
        Object hasGirl2 = getProperty(boy, "hasGirl");
        System.out.println("name=" + name2 + ", hasGirl=" + hasGirl2);
    }
}
