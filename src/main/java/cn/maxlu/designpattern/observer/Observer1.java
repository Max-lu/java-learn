package cn.maxlu.designpattern.observer;

import javax.swing.*;

public class Observer1 implements Observer {
    @Override
    public void update(Observable subject, Object value) {
        if (value instanceof String) {
            String name = (String) value;
            JFrame jFrame = new JFrame("observer");
            JLabel jLabel = new JLabel("update name to : " + name);
            jFrame.add(jLabel);
            jFrame.pack();
            jFrame.setVisible(true);
            System.out.println(subject + " update name to : " + name);
        }
    }
}
