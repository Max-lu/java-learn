package cn.maxlu.zookeeper;

import org.apache.zookeeper.*;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.util.concurrent.CountDownLatch;

/**
 * Created by lw on 2016/7/3.
 */
public class ServiceProvider {

    private CountDownLatch latch = new CountDownLatch(1);

    public void publish(Remote remote, String host, int port) {
        String url = publishService(remote, host, port);
        if (url != null) {
            ZooKeeper zk = connectServer();
            if (zk != null) {
                createNode(zk, url);
            }
        }
    }

    private void createNode(ZooKeeper zk, String url) {
        try {
            byte[] data = url.getBytes();
            String path = zk.create(Constant.ZK_PROVIDER_PATH, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            System.out.println("create zookeeper node, " + path + " ==> " + url);
        } catch (Exception e) {
            System.err.println("error : " + e.getMessage());
        }
    }

    private ZooKeeper connectServer() {
        ZooKeeper zk = null;
        try {
            zk = new ZooKeeper(Constant.ZK_CONNECTION_STRING, Constant.ZK_SESSION_TIMEOUT, watchedEvent -> {
                if (watchedEvent.getState() == Watcher.Event.KeeperState.SyncConnected) {
                    latch.countDown();
                }
            });
            latch.wait();
        } catch (Exception ex) {
            System.err.println("error : " + ex.getMessage());
        }
        return zk;
    }

    private String publishService(Remote remote, String host, int port) {
        String url = null;
        try {
            url = String.format("rmi://%s:%d/%s", host, port, remote.getClass().getName());
            LocateRegistry.createRegistry(port);
            Naming.rebind(url, remote);
            System.out.println("publish rmi service, url = " + url);
        } catch (Exception ex) {
            System.err.println("error:" + ex.getMessage());
        }
        return url;
    }
}
