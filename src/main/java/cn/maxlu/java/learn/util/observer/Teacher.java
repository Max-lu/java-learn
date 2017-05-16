package cn.maxlu.java.learn.util.observer;

import java.util.Observable;

/**
 * Created by luwei on 2017/5/16.
 */
class Teacher extends Observable {
    private String name;

    Teacher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected void askQuestion(String question) {
        setChanged();
        notifyObservers(question);
    }

    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }
}
