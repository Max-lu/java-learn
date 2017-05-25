package cn.maxlu.servlet.listener.httpsession;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

@WebListener
public class MyHttpSessionActivationListener implements HttpSessionActivationListener{
    @Override
    public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        Object kdk = session.getAttribute("kdk");
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {

    }
}
