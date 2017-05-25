package cn.maxlu.designpattern.observer;

import javax.swing.*;

public class Observer2 implements Observer {
    @Override
    public void update(Observable subject, Object value) {
        if (value instanceof Integer) {
            Integer age = (Integer) value;
            JFrame jFrame = new JFrame("observer");
            JLabel jLabel = new JLabel("update age to : " + age);
            jFrame.add(jLabel);
            jFrame.pack();
            jFrame.setVisible(true);
            System.out.println(subject + " update age to : " + age);
        }
    }
}
