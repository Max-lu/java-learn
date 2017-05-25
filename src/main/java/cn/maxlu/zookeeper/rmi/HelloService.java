package cn.maxlu.zookeeper.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by lw on 2016/7/3.
 */
public interface HelloService extends Remote {
    String sayHello(String name) throws RemoteException;
}
