package zookeeper.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Created by lw on 2016/7/3.
 */
public class RmiClient {
    public static void main(String[] args) throws Exception {
        String url = "rmi://localhost:1099/demo.rmi";
        HelloService helloService = (HelloService) Naming.lookup(url);
        String result = helloService.sayHello("jack");
        System.out.println(result);
    }
}
