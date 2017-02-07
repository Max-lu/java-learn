package copy;

/**
 * Created by max.lu on 2016/2/2.
 */
public class StudentDeepCopy implements Cloneable{

    private String name;

    private Teacher teacher;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        StudentDeepCopy studentDeepCopy = (StudentDeepCopy) super.clone();
        studentDeepCopy.setTeacher((Teacher) teacher.clone());
        return studentDeepCopy;
    }
}
