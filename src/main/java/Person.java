import java.io.Serializable;

/**
 * Created by max.lu on 2015/12/30.
 */
public class Person implements Cloneable, Serializable{


    private static final long serialVersionUID = -5437436730032433428L;

    private Integer id;
    private String name;
    private Integer age;


    public Person() {
        System.out.println("constructor");
    }

    public Person(Integer id, String name, Integer age ) {
        this.id = id;
        this.age =age;
        this.name = name;
    }
    public Integer getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
