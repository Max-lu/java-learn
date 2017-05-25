package cn.maxlu.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Created by lw on 2016/7/3.
 */
class WebAppContextWithWarServer {
    public static void main(String[] args) {
        Server server = new Server(8080);
        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("myApp");
        webAppContext.setWar("struts-demo.war");
        server.setHandler(webAppContext);
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
