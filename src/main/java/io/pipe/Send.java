package io.pipe;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * Created by max.lu on 2016/3/24.
 */
public class Send implements Runnable {
    private PipedOutputStream out;

    public Send() {
        this.out = new PipedOutputStream();
    }

    @Override
    public void run() {
        String message = "hello world";
        try {
            out.write(message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PipedOutputStream getOut() {
        return out;
    }
}
