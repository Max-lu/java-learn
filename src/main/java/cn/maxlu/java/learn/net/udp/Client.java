package cn.maxlu.java.learn.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by luwei on 2017/6/1.
 */
public class Client {
    public static void main(String[] args) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();
        byte[] buffer = "hello world".getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("127.0.0.1"), 9001);
        clientSocket.send(packet);

        byte[] buffer2 = new byte[11];
        DatagramPacket packet2 = new DatagramPacket(buffer, buffer.length);
        clientSocket.receive(packet2);

        byte[] data = packet2.getData();
        System.out.println("receive message:" + new String(data));
    }
}
