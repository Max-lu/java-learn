package cn.maxlu.ognl;

import ognl.Ognl;
import ognl.OgnlException;
import org.junit.Test;

import java.util.*;

/**
 * Created by luwei on 2017/5/16.
 */
//todo 考虑使用场景
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

    @Test
    public void thisTest() throws OgnlException {
        Object root = new Object();
        Map<String, Object> context = new HashMap<>();

        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            values.add(i);
        }
        context.put("values", values);

        Ognl.getValue("@System@out.println(#values.size.(#this > 10 ? '大于10' : '不大于10'))", context, root);


        Student student = new Student("max", new Teacher("jason"));
        Ognl.getValue("setName('MAX')", student);
        Ognl.getValue("@System@out.println(#this.name)", student);
        Ognl.getValue("@System@out.println(name.(#this.toLowerCase()))", student);

    }

    @Test
    public void bracketTest() throws OgnlException {
        Teacher teacher = new Teacher("jason2");
        Student root = new Student("max", new Teacher("jason"));

        Map<String, Object> context = new HashMap<>();
        context.put("t", teacher);
        context.put("fact", "name");

        //#fact ==> context.get("fact") ==> name
        //#t ==> context.get("t") ==> teacher
        //#fact(#t) ==> teacher.getName()
        //相当于将#t所得的值作为root来求#fact的值，即相当于teacher.getName
        Object value = Ognl.getValue("#fact(#t)", context, root);
        System.out.println(value);

        //#t ==> context.get("t") ==> teacher
        //fact(#t) ==> root.fact(teacher)
        //调用root的fact方法，并将#t作为参数，即相当于student.fact(teacher)
        Object value2 = Ognl.getValue("fact(#t)", context, root);
        System.out.println(value2);

        //(fact) ==> root.getFact ==> name
        //#t ==> context.get("t") ==> teacher
        //(fact)(#t) ==> teacher.getName()
        //root的fact属性，即相当于teacher.getName
        Object value3 = Ognl.getValue("(fact)(#t)", context, root);
        System.out.println(value3);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void collectionTest() throws OgnlException {
        Object root = new Object();
        Map<String, Object> context = new HashMap<>();

        List<Integer> list = (List<Integer>) Ognl.getValue("{1, 2, 3}", context, root);
        context.put("list", list);

        int[] array = (int[]) Ognl.getValue("new int[]{4, 5, 6}", context, root);
        context.put("array", array);

        Map<String, Object> map = (Map<String, Object>) Ognl.getValue("#{'list':#list, 'array':#array}", context, root);
        context.put("map", map);

        System.out.println(list);
        System.out.println(Arrays.toString(array));
        System.out.println(map);


        Ognl.getValue("@System@out.println(#list[0])", context, root);
        Ognl.getValue("@System@out.println(#array[0])", context, root);
        Ognl.getValue("@System@out.println(#map['list'][1])", context, root);
        Ognl.getValue("@System@out.println(#map.list[2])", context, root);
    }
}
