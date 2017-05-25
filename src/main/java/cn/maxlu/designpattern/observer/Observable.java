package cn.maxlu.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {

    List<Observer> observerList = new ArrayList<>();

    public void register(Observer observer) {
        if (!observerList.contains(observer)) {
            observerList.add(observer);
        }
    }

    public void remove(Observer observer) {
        if (observerList.contains(observer)) {
            observerList.remove(observer);
        }
    }

    public void notifyObservers(Object value) {
        for (Observer observer : observerList) {
            observer.update(this, value);
        }
    }
}
