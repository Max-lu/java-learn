package cn.maxlu.java.learn.basic.clone;

import java.io.Serializable;

/**
 * Created by max.lu on 2016/2/2.
 */
class TeacherSerial implements Serializable {

    private static final long serialVersionUID = 1L;

    public TeacherSerial(){

    }

    TeacherSerial(String name){
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
