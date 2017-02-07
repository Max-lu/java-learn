package io.pipe;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * Created by max.lu on 2016/3/24.
 */
public class Receive implements Runnable {
    private PipedInputStream in;

    public Receive() {
        in = new PipedInputStream();
    }

    @Override
    public void run() {
        byte[] result = new byte[1024];
        int len = 0;
        try {
            len = in.read(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(new String(result, 0, len));
    }

    public PipedInputStream getIn() {
        return in;
    }
}
