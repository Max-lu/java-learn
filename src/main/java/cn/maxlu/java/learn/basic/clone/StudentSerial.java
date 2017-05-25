package cn.maxlu.java.learn.basic.clone;

import java.io.*;

/**
 * Created by max.lu on 2016/2/2.
 */
class StudentSerial implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    private String name;

    private TeacherSerial teacher;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TeacherSerial getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherSerial teacher) {
        this.teacher = teacher;
    }

    public Object deepClone() throws CloneNotSupportedException, IOException, ClassNotFoundException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(this);
        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);
        return oi.readObject();
    }
}
