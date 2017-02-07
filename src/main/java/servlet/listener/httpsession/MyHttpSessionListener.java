package servlet.listener.httpsession;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;

@WebListener
public class MyHttpSessionListener implements HttpSessionListener, ServletContextListener{
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        ServletContext servletContext = session.getServletContext();
        AtomicInteger sessionCount = (AtomicInteger) servletContext.getAttribute("sessionCount");
        int nowCount = sessionCount.incrementAndGet();
        System.out.println("create-session count = " + nowCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        ServletContext servletContext = session.getServletContext();
        AtomicInteger sessionCount = (AtomicInteger) servletContext.getAttribute("sessionCount");
        int nowCount = sessionCount.decrementAndGet();
        System.out.println("destroy-session count = " + nowCount);
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        AtomicInteger sessionCount = new AtomicInteger();
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("sessionCount", sessionCount);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("context destroy...");
    }
}
