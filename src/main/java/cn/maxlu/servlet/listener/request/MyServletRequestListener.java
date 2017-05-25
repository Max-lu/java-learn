package cn.maxlu.servlet.listener.request;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class MyServletRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        ServletRequest servletRequest = servletRequestEvent.getServletRequest();
        long start = (long) servletRequest.getAttribute("start");
        long end = System.nanoTime();

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        StringBuffer url = httpServletRequest.getRequestURL();
        System.out.println("request cost : " + (end - start)/1000000 + "ms  url=" + url);
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        ServletRequest servletRequest = servletRequestEvent.getServletRequest();
        servletRequest.setAttribute("start", System.nanoTime());
    }
}
