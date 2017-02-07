package zookeeper.rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by lw on 2016/7/3.
 */
public class RmiServer {
    public static void main(String[] args) throws Exception {
        int port = 1099;
        String url = "rmi://localhost:1099/demo.rmi";
        LocateRegistry.createRegistry(port);
        Naming.rebind(url, new HelloServiceImpl());
    }
}
