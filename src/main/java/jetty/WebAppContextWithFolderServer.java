package jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Created by lw on 2016/7/3.
 */
public class WebAppContextWithFolderServer {
    public static void main(String[] args) {
        Server server = new Server(8080);
        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/myApp");
        webAppContext.setDescriptor("E:\\Code\\my\\MyProject\\Struts2Module\\src\\main\\webapp\\WEB-INF\\web.xml");
        webAppContext.setResourceBase("E:\\Code\\my\\MyProject\\Struts2Module");
        webAppContext.setParentLoaderPriority(true);
        server.setHandler(webAppContext);
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
