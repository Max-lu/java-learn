package copy;

/**
 * Created by max.lu on 2016/2/2.
 */
public class Teacher implements Cloneable {

    public Teacher(){

    }

    public Teacher(String name){
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
