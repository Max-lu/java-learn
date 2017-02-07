package reflect.convert;

/**
 * Created by max.lu on 2016/2/3.
 */
public class Data1 {

    private Integer id;

    protected String name;

    public String sex;

    public int age;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public Data1 setId(Integer id) {
        this.id = id;
        return this;
    }

    public Data1 setName(String name) {
        this.name = name;
        return this;
    }

    public Data1 setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public Data1 setAge(int age) {
        this.age = age;
        return this;
    }
}
