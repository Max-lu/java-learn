package cn.maxlu.java.learn.reflect.convert;

/**
 * Created by max.lu on 2016/2/3.
 */
public class ConvertTest {
    public static void main(String[] args) {
        Data1 data1 = new Data1();
        data1.setId(1).setName("max1").setAge(1).setSex("man");
        System.out.println("data1:");
        System.out.println(data1.getId() + " " + data1.getName() + " " + data1.getAge() + " " + data1.getSex() + " ");
        Data2 data2 = new Data2();
        DataConvert.convert(data2, data1);
        System.out.println("data2:");
        System.out.println(data2.getId() + " " + data2.getName() + " " + data2.getAge() + " " + data2.getSex() + " ");
    }
}
