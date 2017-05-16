package cn.maxlu.ognl;

import ognl.Ognl;
import ognl.OgnlException;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by luwei on 2017/5/16.
 */
public class OgnlTest {
    @Test
    public void getValueTest() throws OgnlException {
        Student student = new Student("max", new Teacher("jason"));

        Object name = Ognl.getValue("name", student);
        System.out.println(name);

        Object name2 = Ognl.getValue("teacher.name", student);
        System.out.println(name2);

        Object name3 = Ognl.getValue("#root.teacher.name", student);
        System.out.println(name3);
    }

    @Test
    public void contextTest() throws OgnlException {
        Student root = new Student("max", new Teacher("jason"));
        Student student1 = new Student("max1", new Teacher("jason1"));
        Student student2 = new Student("max2", new Teacher("jason2"));

        Map<String, Object> context = new HashMap<>();
        context.put("s1", student1);
        context.put("s2", student2);

        Object name = Ognl.getValue("name + ',' + #s1.name + ',' + #s2.name", context, root);
        System.out.println(name);

        Object name2 = Ognl.getValue("#s1.name + ',' + #s2.name", context, new Object());
        System.out.println(name2);

    }

    @Test
    public void setValueTest() throws OgnlException {
        Student student = new Student("max", new Teacher("jason"));

        Ognl.setValue("name", student, "max2");
        Ognl.setValue("teacher.name", student, "jason2");

        System.out.println(student.getName());
        System.out.println(student.getTeacher().getName());

        Map<String, Object> context = new HashMap<>();
        context.put("s", student);

        Ognl.setValue("#s.name", context, new Object(), "max3");
        Ognl.setValue("#s.teacher.name", context, new Object(), "jason3");

        System.out.println(student.getName());
        System.out.println(student.getTeacher().getName());
    }

    @Test
    //使用getValue来设置值
    public void setValueTest2() throws OgnlException {
        Student student = new Student("max", new Teacher("jason"));

        Ognl.getValue("name='max2'", student);
        Ognl.getValue("teacher.name='jason2'", student);

        System.out.println(student.getName());
        System.out.println(student.getTeacher().getName());

        Map<String, Object> context = new HashMap<>();
        context.put("s", student);

        Ognl.getValue("#s.name='max3'", context, new Object());
        Ognl.getValue("#s.teacher.name='jason3'", context, new Object());

        System.out.println(student.getName());
        System.out.println(student.getTeacher().getName());

        Ognl.getValue("#s.name='max4',#s.teacher.name='jason4'", context, new Object());
        System.out.println(student.getName());
        System.out.println(student.getTeacher().getName());
    }

    @Test
    public void executeMethodTest() throws OgnlException {
        Student student = new Student("max", new Teacher("jason"));
        Object value = Ognl.getValue("name()", student);
        System.out.println(value);

        Ognl.getValue("setName('max2')", student);
        System.out.println(student.getName());
    }
}
