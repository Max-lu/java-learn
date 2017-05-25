package cn.maxlu.servlet.async;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import java.io.IOException;


public class MyAsyncListener implements AsyncListener {
    @Override
    public void onComplete(AsyncEvent event) throws IOException {
        System.out.println("async complete");
    }

    @Override
    public void onTimeout(AsyncEvent event) throws IOException {
        System.out.println("async timeout");
    }

    @Override
    public void onError(AsyncEvent event) throws IOException {
        System.out.println("async error");
    }

    @Override
    public void onStartAsync(AsyncEvent event) throws IOException {
        System.out.println("async start");
    }
}
