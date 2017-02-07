package io.pipe;

import java.io.IOException;

/**
 * Created by max.lu on 2016/3/24.
 */
public class Test {
    public static void main(String[] args) {
        Send send = new Send();
        Receive receive = new Receive();
        try {
            send.getOut().connect(receive.getIn());
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(send).start();
        new Thread(receive).start();
    }
}
