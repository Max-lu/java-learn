package cn.maxlu.ognl;

/**
 * Created by luwei on 2017/5/16.
 */
class Student {
    private String name;

    private Teacher teacher;

    public Student(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }

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

    public String name() {
        return name + "22";
    }
}
