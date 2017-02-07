package jetty;

import org.eclipse.jetty.server.Server;

/**
 * Created by lw on 2016/7/3.
 */
public class TestJetty {

    public static void main(String[] args) {
        Server server = new Server(8080);
        try {
            server.setHandler(new HelloHandler());
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
