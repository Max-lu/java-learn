package reflect;

import java.lang.reflect.Field;

/**
 * Created by max.lu on 2016/1/26.
 */
public class Test {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        Student student = new Student();
        student.setId(1);
        student.setName("max1");
        student.setAge(100);

        //can only get public field
//        Field field1 = student.getClass().getField("id");

        Field field2 = student.getClass().getField("age");
        System.out.println(field2.getName() + ":" + field2.get(student));

        Field field3 = student.getClass().getDeclaredField("id");
        field3.setAccessible(true);
        System.out.println(field3.getName() + ":" + field3.get(student));

        System.out.println("\n" + field2.equals(field3));
        System.out.println(field2.getAnnotatedType());
        System.out.println(field2.getType());
        System.out.println(field2.getModifiers());

        //java.lang.IllegalArgumentException: Can not set java.lang.Integer field reflect.Student.age to (int)200
//        field2.setInt(student, 200);
        field2.set(student, 200);
        System.out.println(field2.get(student));

        //set field value
        System.out.println("\nset field value:");
        System.out.println("before:");
        System.out.println(student.getId() + " ---> " + student.getName());
        Field[] fields = student.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getName().equalsIgnoreCase("id")) {
                field.set(student, 2);
            }
            if (field.getName().equalsIgnoreCase("name")) {
                field.set(student, "max2");
            }
        }
        System.out.println("after:");
        System.out.println(student.getId() + " ---> " + student.getName());
    }

}
